OGNL expression language is simple and powerful. 
OGNL expression language helps in accessing the values stored on the ValueStack 
and in the ActionContext.
The OGNL is very similar to the JSP Expression Language. 

It is important to understand that the Action object is always available in the value stack. So, therefore if your Action object has properties x and y there are readily available for you to use.

Objects in the ActionContext are referred using the pound symbol, however, the objects in the value stack can be directly referenced, for example if employee is a property of an action class then it can ge referenced as follows:

  <s:property value="name"/>
instead of

  <s:property value="#name"/>
  
  
  If you have an attribute in session called "login" you can retrieve it as follows:

  <s:property value="#session.login"/>
  
  
  ***********************************************************************************
  OGNL stands for Object-Graph Navigation Language; it is an expression language for getting and setting properties of Java objects. You use the same expression for both getting and setting the value of a property.

The struts 2 framework uses a standard naming context to evaluate OGNL expressions. In expression, the properties of the root object can be referenced without any special "marker" notion. References to other objects are marked with a pound sign (#).

The framework sets the OGNL context to be our ActionContext, and the value stack
 to be the OGNL root object. (The value stack is a set of several objects, but 
 to OGNL it appears to be a single object.) Along with the value stack, the 
 framework places other objects in the ActionContext, including Maps representing 
 the application, session, and request contexts. These objects coexist in the
  ActionContext, alongside the value stack (our OGNL root).
The Action instance is always pushed onto the value stack. 
Because the Action is on the stack, and the stack is the OGNL root, references 
to Action properties can omit the # marker. But, to access other objects in the
 ActionContext, we must use the # notation so OGNL knows not to look in the root object, 
 but for some other object in the ActionContext.
 
                     |--application
                     |
                     |--session
       context map---|
                     |--value stack(root)
                     |
                     |--request
                     |
                     |--parameters
                     |
                     |--attr (searches page, request, session, then application scopes)
                     |
Referencing an Action property
<s:property value="name"/>
Other (non-root) objects in the ActionContext can be rendered use the # notation.
<s:property value="#session.mySessionKey"/> or
<s:property value="#request['myRequestKey']"/>
The ActionContext is also exposed to Action classes via a static method.
ActionContext.getContext().getSession().put("mySessionPropKey", mySessionObject);