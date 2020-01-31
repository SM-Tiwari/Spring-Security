package com.gnv.vnm.selfcare.webportal.filter;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.security.AuthConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -7813450481469408963L;
	
    private String issuer = AuthConstants.JWT_ISSUER;
	private String signature = AuthConstants.JWT_SIGNATURE;
	private long expiration = AuthConstants.TOKEN_VALIDITY_IN_MINUTES * 60 * 60 * 1000;
	
	public JwtTokenUtil() {}

	public JwtTokenUtil(String issuer, String signature, long expiration) {
		this.issuer = issuer;
		this.signature = signature;
		this.expiration = expiration;
	}

    /**
	 * @return the issuer
	 */
	public String getIssuer() {
		return issuer;
	}

	/**
	 * @param issuer the issuer to set
	 */
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * @return the expiration
	 */
	public long getExpiration() {
		return expiration;
	}

	/**
	 * @param expiration the expiration to set
	 */
	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}

	public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
         
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    
    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(AuthConstants.JWT_CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(signature).parseClaimsJws(token).getBody();
        } catch (Exception e) {
        	e.printStackTrace();
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, signature)
                .compact();
    }
    
    public String generateToken(String userName, String fingerPrint) {

        Claims claims = Jwts.claims().setSubject(userName);
        
        if (StringUtils.hasText(fingerPrint)) {
        	claims.put(AuthConstants.JWT_CLAIM_FGP, fingerPrint);
        }

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer(issuer)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, signature)
                .compact();
    }
    
    public Boolean canTokenBeRefreshed(String token) {
        return  !isTokenExpired(token);
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(AuthConstants.JWT_CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    
    public Boolean validateToken(String token, String theUserName) {
        final String username = getUsernameFromToken(token);
        return (username.equals(theUserName) && !isTokenExpired(token));
    }
	public Boolean validateTokenWithOutExpireds(String token, String theUserName) {
        final String username = getUsernameFromToken(token);
        return (username.equals(theUserName));
    }
	
}
