package com.cs.cloud.core.portal.servlet;

import java.io.IOException;
import java.net.URI;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriBuilderException;

import org.glassfish.jersey.server.internal.ContainerUtils;
import org.glassfish.jersey.uri.UriComponent;


public class ServletContainer extends HttpServlet implements Filter {

    /**
     * <p>
     * <b> TODO : Insert description of the field. </b>
     * </p>
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

        System.out.println("public void init(final FilterConfig filterConfig) throws ServletException {");

    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {

        System.out.println("public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {");

    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {");
        super.doGet(req, resp);
    }

    @Override
    protected long getLastModified(final HttpServletRequest req) {

        System.out.println("protected long getLastModified(final HttpServletRequest req) {");
        return super.getLastModified(req);
    }

    @Override
    protected void doHead(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("protected void doHead(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {");
        super.doHead(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {");
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("protected void doPut(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {");
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("protected void doDelete(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {");
        super.doDelete(req, resp);
    }

    @Override
    protected void doOptions(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("protected void doOptions(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {");
        super.doOptions(req, resp);
    }

    @Override
    protected void doTrace(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("protected void doTrace(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {");
        super.doTrace(req, resp);
    }

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {");
        final String servletPath = req.getServletPath();
        final StringBuffer requestUrl = req.getRequestURL();
        final String requestURI = req.getRequestURI();
        final String contextPath = req.getContextPath();
        String key001 = req.getParameter("Key001");

        System.err.println("req.getServletPath()=" + servletPath);
        System.err.println("req.getRequestURL()=" + requestUrl);
        System.err.println("req.getRequestURI()=" + requestURI);
        System.err.println("req.getContextPath()=" + contextPath);
        System.err.println("req.getParameter(\"Key001\")=" + key001);


        final UriBuilder absoluteUriBuilder;
        try {
            absoluteUriBuilder = UriBuilder.fromUri(requestUrl.toString());
        } catch (final IllegalArgumentException iae) {
            setResponseForInvalidUri(resp, iae);
            return;
        }
        final String decodedBasePath = req.getContextPath() + servletPath + "/";

        final String encodedBasePath = UriComponent.encode(decodedBasePath, UriComponent.Type.PATH);

        if (!decodedBasePath.equals(encodedBasePath)) {
            throw new ProcessingException("The servlet context path and/or the " + "servlet path contain characters that are percent encoded");
        }

        final URI baseUri;
        final URI requestUri;
        try {
            baseUri = absoluteUriBuilder.replacePath(encodedBasePath).build();
            String queryParameters = ContainerUtils.encodeUnsafeCharacters(req.getQueryString());
            if (queryParameters == null) {
                queryParameters = "";
            }

            requestUri = absoluteUriBuilder.replacePath(requestURI).replaceQuery(queryParameters).build();
        } catch (final UriBuilderException | IllegalArgumentException ex) {
            setResponseForInvalidUri(resp, ex);
            return;
        }
    }

    @Override
    public void service(final ServletRequest req, final ServletResponse res) throws ServletException, IOException {


        System.out.println("public void service(final ServletRequest req, final ServletResponse res) throws ServletException, IOException {");
        if (!(req instanceof HttpServletRequest && res instanceof HttpServletResponse)) {
            throw new ServletException("non-HTTP request or response");
        }

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        service(request, response);
    }

    private void setResponseForInvalidUri(final HttpServletResponse response, final Throwable throwable) throws IOException {


        final Response.Status badRequest = Response.Status.BAD_REQUEST;
        response.sendError(badRequest.getStatusCode(), badRequest.getReasonPhrase());
    }

    @Override
    public void destroy() {

        System.out.println("public void destroy() {");
        super.destroy();
    }

    @Override
    public String getInitParameter(final String name) {

        System.out.println("public String getInitParameter(final String name) {");
        return super.getInitParameter(name);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {

        System.out.println("public Enumeration<String> getInitParameterNames() {");
        return super.getInitParameterNames();
    }

    @Override
    public ServletConfig getServletConfig() {

        System.out.println("public ServletConfig getServletConfig() {");
        return super.getServletConfig();
    }

    @Override
    public ServletContext getServletContext() {

        System.out.println("public ServletContext getServletContext() {");
        return super.getServletContext();
    }

    @Override
    public String getServletInfo() {

        System.out.println("public String getServletInfo() {");
        return super.getServletInfo();
    }

    @Override
    public void init(final ServletConfig config) throws ServletException {

        System.out.println("public void init(final ServletConfig config) throws ServletException {");
        super.init(config);
    }

    @Override
    public void init() throws ServletException {

        System.out.println("public void init() throws ServletException {");
        super.init();
    }

    @Override
    public void log(final String msg) {

        System.out.println(" public void log(final String msg) {");
        super.log(msg);
    }

    @Override
    public void log(final String message, final Throwable t) {

        System.out.println("public void log(final String message, final Throwable t) {");
        super.log(message, t);
    }

    @Override
    public String getServletName() {

        System.out.println(" public String getServletName() {");
        return super.getServletName();
    }

}
