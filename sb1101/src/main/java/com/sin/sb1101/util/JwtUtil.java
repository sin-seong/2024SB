package com.sin.sb1101.util;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
@Component
public class JwtUtil {

    private static final String SECRET_KEY = "s!nse@n9";

    public static String generateToken(String username, String role) throws JOSEException {
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .subject(username)
                .claim("role", role)
                .issueTime(new Date())
                .expirationTime(new Date(System.currentTimeMillis()+ 3600000))
                .build();

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);

        SignedJWT signedJWT = new SignedJWT(header, claims);

        MACSigner signer = new MACSigner(SECRET_KEY);
        signedJWT.sign(signer);

        return signedJWT.serialize();
}
    public static String extractRole(String token) throws ParseException, JOSEException{
        SignedJWT signedJWT = SignedJWT.parse(token);

        MACVerifier verifier = new MACVerifier(SECRET_KEY);

        if(signedJWT.verify(verifier)){
            JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();

            Date expirationTime = claimsSet.getExpirationTime();
            if(expirationTime != null && expirationTime.after(new Date())){
                throw new JOSEException("Token has expired");
            }
            return claimsSet.getStringClaim("role");
        }else{
            throw new JOSEException("Invalid token");
        }
    }
}
