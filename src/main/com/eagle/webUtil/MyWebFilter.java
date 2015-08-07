package com.eagle.webUtil;

import com.google.common.hash.Hashing;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jiang on 15/8/2.
 */
public class MyWebFilter extends CharacterEncodingFilter {
    private String encoding;

    private boolean forceEncoding = false;


    public String getEncoding() {
        return encoding;
    }

    @Override
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public boolean isForceEncoding() {
        return forceEncoding;
    }

    @Override
    public void setForceEncoding(boolean forceEncoding) {
        this.forceEncoding = forceEncoding;
    }

    public void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        super.setEncoding(encoding);
        super.setForceEncoding(forceEncoding);

        String requestUri = request.getRequestURI();

        if ("/".equals(requestUri) || "/index.jsp".equals(requestUri)) {
            String eTag = Hashing.goodFastHash(32).hashUnencodedChars("/index.jsp").toString();
            String ifNotModified = request.getHeader("If-None-Match");
            if (eTag.equals(ifNotModified)) {
                response.setStatus(HttpStatus.NOT_MODIFIED.value());
                response.setHeader("Cache-Control", "max-age=300");
            } else {
                response.setHeader("Etag", eTag);
                response.setHeader("Cache-Control", "max-age=300");
            }


        }
        super.doFilterInternal(request, response, filterChain);
    }
}
