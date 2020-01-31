<%-- 
    Document   : proxy
    Created on : Aug 8, 2017, 7:28:13 PM
    Author     : edwin < edwinkun at gmail dot com >
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page session="false"%>
<%@page import="java.net.*,java.io.*" %>
<%
    Logger logger = Logger.getLogger( "proxy" );
    String req01 = "";
    String reqUrl = "";
    
    Enumeration headerNames = request.getHeaderNames();
    HashMap<String, String> mapHeaderInfo = new HashMap<String, String>();
    while (headerNames.hasMoreElements()) {
        String key = (String) headerNames.nextElement();
        String value = request.getHeader(key);
        if (!key.equalsIgnoreCase("host")) 
            mapHeaderInfo.put(key, value);
    }
    
    try {
        reqUrl = request.getQueryString();
        
        long timestamp = System.currentTimeMillis();
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("\r\n========== START =============== \r\n"); 
        sb.append("Timestamp\t:\t").append(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date())).append("\r\n");
        sb.append("Accessing\t:\t").append(reqUrl).append("\r\n");
        sb.append("Headers\t\t:\t").append(mapHeaderInfo.toString()).append("\r\n");
        
        URL url = new URL(reqUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod(request.getMethod());

        Iterator headerIterator = mapHeaderInfo.entrySet().iterator();
        while (headerIterator.hasNext()) {
            Map.Entry pair = (Map.Entry)headerIterator.next();
            con.setRequestProperty(pair.getKey().toString(),pair.getValue().toString());
            headerIterator.remove(); // avoids a ConcurrentModificationException
        }
        
        int clength = request.getContentLength();
        if (request.getContentType() != null) {
            con.setRequestProperty("Content-Type", request.getContentType());
            if(request.getContentType().toLowerCase().contains("text/xml")) {
                clength = 1; // workaround for stupid axis 2 wsdl request, not giving content-length ****
            }
        }
        
        if (clength > 0) {
            con.setDoInput(true);
            InputStream istream = request.getInputStream();
            OutputStream os = con.getOutputStream();
            final int length = 20000;
            byte[] bytes = new byte[length];
            int bytesRead = 0;
            while ((bytesRead = istream.read(bytes, 0, length)) > 0) {
                os.write(bytes, 0, bytesRead);
            }
            req01 = new String(bytes, "UTF-8").trim();
            sb.append("Request \t:\t").append(req01).append("\r\n");
        }
        
        out.clear();
        out = pageContext.pushBody();
        OutputStream ostream = response.getOutputStream();
        response.setContentType(con.getContentType());
        InputStream in = con.getInputStream();
        final int length = 800000;
        byte[] bytes = new byte[length];
        int bytesRead = 0;
        while ((bytesRead = in.read(bytes, 0, length)) > 0) {
            ostream.write(bytes, 0, bytesRead);
        }
        sb.append("Response \t:\t").append(new String(bytes, "UTF-8").trim()).append("\r\n");
        sb.append("Code\t\t:\t").append(con.getResponseCode()+" "+con.getResponseMessage()).append("\r\n");
        sb.append("Time\t\t:\t").append(System.currentTimeMillis() - timestamp).append("ms \r\n");
        sb.append("==========  END  =============== \r\n"); 
        
        logger.info(sb.toString());
    } catch (Exception e) {
        response.setStatus(500);
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n========== START =============== \r\n"); 
        sb.append("URL \t\t:\t").append(reqUrl).append("\r\n");
        sb.append("BODY \t\t:\t").append(req01).append("\r\n");
        sb.append("HEADERS \t:\t").append(mapHeaderInfo).append("\r\n");
        sb.append("ERROR \t\t:\t").append(e.getCause()).append("\r\n");
        for (StackTraceElement elem : e.getStackTrace()) {
            sb.append("ERROR \t\t:\t\t").append(elem.toString()).append("\r\n");        
        }
        sb.append("==========  END  =============== \r\n"); 
        logger.info(sb.toString());
    }
%>