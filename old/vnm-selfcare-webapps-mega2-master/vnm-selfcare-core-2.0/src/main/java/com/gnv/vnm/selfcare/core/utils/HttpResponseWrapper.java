package com.gnv.vnm.selfcare.core.utils;

import java.util.Arrays;

import org.apache.commons.httpclient.Header;

/**
 * @author nandipinto
 *
 */
public class HttpResponseWrapper {

	private int code = -1;
	private String content;
	private Header[] headers;
	
	public HttpResponseWrapper(){ }
	
	public HttpResponseWrapper(int code, String content, Header[] headers) {
		this.code = code;
		this.content = content;
		this.headers = headers;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String description) {
		this.content = description;
	}

	public Header[] getHeaders() {
		return headers;
	}

	public void setHeaders(Header[] headers) {
		this.headers = headers;
	}
	
	public String getHeaderValue(String headerName){
		if (headers == null) return null;
		
		for (int i=0; i<headers.length; i++){
			if (headers[i].getName().equalsIgnoreCase(headerName)){
				return headers[i].getValue();
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HttpResponseWrapper [http_status_code=");
		builder.append(code);
		builder.append(", response_body=");
		builder.append(content);
		builder.append(", headers=");
		builder.append(Arrays.toString(headers));
		builder.append("]");
		return builder.toString();
	}
}
