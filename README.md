# Cyber-Shopping - Jave EE
This was a really fun program I had made for a midterm exam in my CST 4713 - Dynamic Web DevelopmentL Servlet and JSP course. 

The emphasis of this program was to have us combine all the knowledge we have learned thus far into one program.

Tools used were mostly from the javax.servlet library - Cookies, Sessions, Redirects, Html, Apache Tomcat, Etc.

The flow of the project goes as follows:

Create following Shopping site with only Servlets.

Your site should start from CyberShopping.java servlet which does following: 

Step 1: Your site only works for IE (check word "Trident" for IE or not). If not, show error page using HTML standard error code "HttpServletResponse.SC_HTTP_VERSION_NOT_SUPPORTED" and your message "Only Microsoft IE browser is working for this site."

Step 2: Check if user is first time visitor by checking the cookie "Visit" yer or no. if new visitor, set " Visit " cookie with yes for one year and move user to StartMyShopping.java servlet. 

Step 3: The header of  StartMyShopping.java should say "Welcome New Visitor" when  if user is new visitor. Otherwise, just "Welcome Back".

Step 4: From StartMyShopping.java, does following: This page has one shopping item text box that user can type any item but blank with "Add to Shopping List" button to add to shopping list (shoppingList.java).

Step 5: If user types blank and submit "Add" button, system should show same page with error message "Please enter shopping item." next to the shopping item text box.

Step 6: From shoppingList.java, it just shows all shopping list you added so far in list format. And, at the end, you have a link to go back "Keep Shopping" to  StartMyShopping.java. All shopping items must be stored in a session value. So, whenever you add new item from  StartMyShopping.java page, your list keeps previous items in list and just add new one.


