# Servlet_ServletWrappers

Wrappers are required because the current implementation of the interface is container specific and hence you cannot extend them.
However you can extend the wrappers and override only those methods that are required to be changed.
The remaining method calls will be delegated to the container implementation. 
You may also implement the interfaces from scratch on your own, but that would be a very difficult and time consuming task.

If you need to extend the functionality of request or response objects, there are wrapper classes that can wrap around current request or response. The wrapper classes implements the required interfaces so that we can pass it to any place that expects those interface implementations. These wrappers will simply delegate the calls to the default container implementation of the request and response interfaces.

Wrappers are required because the current implementation of the interface is container specific and hence you cannot extend them.
However you can extend the wrappers and override only those methods that are required to be changed. 
The remaining method calls will be delegated to the container implementation. 
You may also implement the interfaces from scratch on your own, but that would be a very difficult and time consuming task.

 

API Summary for request and response wrappers

# ServletRequestWrapper

ServletRequestWrapper class implements ServletRequest.

The constructor of ServletRequestWrapper sets the encapsulation:

public ServletRequestWrapper(ServletRequest encapsulatedReq)

An IllegalArgumentException if the argument passed is null

Two extra methods used to modify encapsulated request

ServletRequest getRequest()

void setRequest (ServletRequest encapsulatedReq)

 

# HttpServletRequestWrapper

The HttpServletRequestWrapper class extends ServletRequestWrapper and implements HttpServletRequest

All methods newly implemented in this class are from HttpServletRequest

The constructor of HttpServletRequestWrapper sets the encapsulation:

public HttpServletRequestWrapper(HttpServletRequest wrappedReq)

An IllegalArgumentEceception is thrown if the argument passed is null

Despite taking HttpServletRequest as its parameter, the object is actually stored internally in the ServletRequestWrapper class as a ServleRequest.
Therefore returned object by getRequest() must be casted to HttpServletRequest if it is to be used as such:

HttpServletRequest orig = (HttpServletRequest) wrapper.getRequest();

 

# ServletResponseWrapper

The ServletResponseWrapper class implements ServletResponse

The constructor of ServletResponseWrapper sets the encapsulation:

public ServletResponseWrapper (ServletResponse encapsulatedResp)

An IllegalArgumentEceception is thrown if the argument passed is null

Two extra methods used to modify encapsulated response

ServletResponse getResponse()

void setResponse(ServletResponse encapsulatedResp )

 

# HttpServletResponseWrapper

The HttpServletResponseWrapper class extends ServletResponseWrapper and implements HttpServletResponse.

The constructor of HttpServletResponseWrapper sets the encapsulation:

public HttpServletResponseWrapper (HttpServletResponse wrapped)

An IllegalArgumentEceception is thrown if the argument passed is null

This class uses its parent’s storage mechanism which is of type ServletResponse. It is therefore necessary to explicitly cast the object retrieved from the getResponse method:

HttpServletResponse r = (HttpServletResponse) wrapper.getResponse();

 

Steps to use wrappers

Extend HttpServletRequestWrapper and HttpServletResponseWrapper to create custom wrappers.

E.g. MyHttpServletRequestWrapper extends HttpServletRequestWrapper {}

Creater a wrapper instance over the request object:

E.g. HttpServletRequestWrapper myReqWrapper = new MyHttpServletRequestWrapper (request);

Include or forward using this myReqWrapper passing it instead of request. It should behave exactly as before (without wrappers) now.

Do similar (1-3) for HttpServletResponseWrapper with response object and include or forward using this wrapper passing it instead of response. 

Now you can start making any modifications to your custom wrappers to extend or modify the functionality of request or response objects.

 

# Major applications of request and response wrappers
We can override the stream behavior of request/response object. 
For instance, we can provide an extra layer of buffer using a wrapper with its own internal buffer independent of the output stream supplied by the container. 
We can pass this to other components and once we finally verify the content,
then we can write it into containers output stream and thus actually committing the response. 

Wrappers are more commonly used with filters than directly with servlets using RequestDispatcher mechanism. Filters give more flexibility and can be easily added/removed just by changing the deployment descriptor configuration.
