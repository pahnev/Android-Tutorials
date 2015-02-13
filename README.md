# Android-Tutorials

### Contents
- **TeamTreehouse**
    - [Blog Reader App](#blog-reader-android-app-treehouse)
    - [Self Destructing message app](#self-destructing-message-app-treehouse)
    - [Implementing Designs for Android](#implementing-designs-for-android-treehouse)
    
- **Big Nerd Ranch Guide**
    - [GeoQuiz](#geoquiz)



#Blog Reader Android App [treehouse](http://teamtreehouse.com/library/build-a-blog-reader-android-app)
---

**Challenge 1**
> **Liven up your ListView**
> 
> The ListView can be customized in many ways. Take a look at the [methods or XML attributes](http://developer.android.com/reference/android/widget/ListView.html) you can use to change how your ListView looks, and make it snazzy!
> 
> **Clicks Ahoy!**
> 
> See if you can add interactivity to your ListView using an **OnItemClickListener**. Display a message in a Toast, write something to the log, or even try navigating to a [new activity](http://www.youtube.com/watch?v=01rjbjjQwho).
> 
> **Strings Everywhere!**
> 
> Now that you know how to use String resources in **strings.xml**, go back to your Crystal Ball app and change all the Strings in the project to String resources. Even the array of answers, **CrystalBall.mAnswers**, can be stored as a **<string-array>** resource.

**Challenge 2**
> JSON Google Search
> 
> Use the Google JSON Search API URL to request JSON search results from Google: [https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=JSON](https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=JSON) 
> 
> The last part of the URL after "q=" is the search term.
> 
> 1. Switch to use this URL and log the results.
> 2. Add an EditText and Button to your Activity layout. When the Button is tapped, get the value from the EditText, append it to the URL as the search parameter, and kick off your AsyncTask to perform a custom search.
> 3. Loop through the array of JSON results, pick a data element from each JSON object, store it in a String array, and then adapt that array for viewing in the ListView using an ArrayAdapter.


**Challenge 3**
> **JSON Google Search Redux**
> 
> Building on the extra credit challenge from the last stage, again use the Google JSON Search API URL to request JSON search results from Google: [https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=JSON](https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=JSON)
> 
> The last part of the URL after "q=" is the search term.
>  
> 1. Loop through the array of JSON results, pick two data elements from each JSON object, store them in an ArrayList of HashMap items, and then adapt that ArrayList for viewing in the ListView using a SimpleAdapter.
> 
> 2. See if you can model the JSON data as a Java object. Name the new object something like SearchResult and add properties that correspond to the data elements in the JSON response. Set each property as you loop through the search results.
> 3. If you're feeling really brave, create an ArrayList of **SearchResult** objects instead of HashMaps. Then create a custom adapter to adapt each **SearchResult** as an individual item in the list. There are some good tutorials, examples, and tips on custom list adapters in [this Treehouse Forum thread](https://teamtreehouse.com/forum/custom-listview-course).

**Challenge 4**
> **Sharing Other Data**
> 
> Sharing the URL of the blog post as text is the most basic type of sharing we can do. What other data from the blog post can you share? Check out the "Standard Extra Data" section of the [Intent documentation](http://developer.android.com/reference/android/content/Intent.html) and implement sharing via email using the email fields.
> 
> **Where's My Up Button?**
> 
> The app icon in the Action Bar can be used to [navigate within](http://developer.android.com/guide/topics/ui/actionbar.html#Home) your app. Make the icon act as an "up" button when you're viewing a blog post that takes you "up" to the main list of posts.
> 
> **ActionBarSherlock**
> 
> [ActionBarSherlock](http://actionbarsherlock.com/) is a hugely popular open source library that provides apps with an Action Bar on older versions of Android. Follow the [documentation](http://actionbarsherlock.com/usage.html) to include ActionBarSherlock in the Blog Reader app to make the ActionBar appear and work on older versions.

---
---
---
---

#Self Destructing message app [treehouse](http://teamtreehouse.com/library/build-a-selfdestructing-message-android-app)
---
**Challenge 1:**

> **Alternative Login**
> 
> There is a "Login Activity" template available in Eclipse when creating a new Activity. Add one to your project and take a look at the code that is generated. It includes some helpful form validation, among other things. See if you can replace our LoginActivity with this version (but keep a backup in case you need to go back for the next stage!).

**Challenge 2:**

> **Super Users**
> 
> There is a lot you can do with the ParseUser class. Check out the [documentation](https://www.parse.com/docs/android_guide#users) and see if you can implement a "Forgot Password?" link on the login screen following the instructions in the [Parse Android Guide](https://www.parse.com/docs/android_guide#users-resetting).

**Challenge 3:**

> **Multiple Tabs in One Activity**
> 
> As we have seen, Fragments can be used to display different views in one activity. Create a new project and see if you can display two or more fragments in one Activity. Specifically, two (or more) fragments should be visible on the screen at one time.
> 
> If you want to go even further, add a button in one Fragment that changes a TextView on a second Fragment.

**Challenge 4:**

> **User Profiles: Do we really know our "Friends"**?
> 
> We don't know much about users in the app besides their usernames. Wouldn't it be nice to have additional information that could be displayed when a friend is tapped on?
> 
> 1. Add some additional optional fields to the Sign Up screen. Maybe things like:
> 	- First name
> 	- Last name
> 	- Hometown
> 	- Website
> 2. Store these new fields in the User class on Parse.
> 3. Add onListItemClick()to FriendsFragment and, when a friend is tapped, navigate to a new Profile Activity.
> 4. On the new Profile Activity, display all the additional user data you are collecting.

**Challenge 5:**

> **What about Words?**
> 
> Everything is working for photo and video messages, but what about simple text messages? Add a button next to the camera in the Action Bar that starts a new Activity with an EditText and a button. Capture the text the user enters and take them to the recipients activity to choose recipients. Then adapt the code to send a the text as a message instead of the current path for photos or videos.

**Challenge 6:**

> **Customize the Custom ListView**
> 
> We have additional data about each message that would be nice to display to the user. Extend the custom layout and adapter created in this stage to display the "createdAt" data of each message below the sender's name. Here are a few ideas:
> 
> - Change the size, color, and/or weight of the font to indicate that it's secondary data.
> - Try it in different locations within the item layout--where does it look best?
> - The data is stored as a timestamp, but how can this be made more meaningful? Can you create or find a way to change the display to something like "1 hour ago" (etc.)?

**Challenge 7:**

> **Automatic File Deletion**
> 
> As mentioned in "Deleting Partial Data for One Recipient", the Parse Android API does not currently contain a way to delete a file from within the app. It is possible, however, using the [Parse REST API](https://www.parse.com/questions/how-can-i-delete-a-file). Using an [AsyncTask](http://developer.android.com/guide/components/processes-and-threads.html) like in the [Blog Reader project](http://teamtreehouse.com/library/build-a-blog-reader-android-app/getting-data-from-the-web/moving-work-from-the-main-thread-to-an-asynctask-3), construct a DELETE request to the REST API and delete a file at the same time we delete a message (once it's been viewed by the last recipient).

---
---
---
---

#Implementing Designs for Android [treehouse](http://teamtreehouse.com/library/implementing-designs-for-android)
---
**Challenge 1:**

> **Design Inspiration**
> 
> This stage is about getting started with a design, so your challenge is simply to find some inspiration for Android app design. Check out the [Android Niceties Tumblr](http://androidniceties.tumblr.com/) for a frequently updated collection of inspiring app designs.

**Challenge 2**

> **Customize the Progress Indicator**
> 
> We didn't touch the spinning progress indicator in this redesign, and it's now gone because the Action Bar has been removed. Add a custom progress indicator that shows while the login is being attempted. For a basic example, check out the Progress Bar (circle) used in the Blog Reader video [Cleaning Up our Presentation](http://teamtreehouse.com/library/build-a-blog-reader-android-app/adapting-data-for-display-in-a-list/cleaning-up-our-presentation-2).

**Challenge 3**
> **Alternate Theme**
> 
> Now that you know how to create and set a theme for an app, create an alternate version that uses a different color scheme for Ribbit. You can define it in the same styles.xml file. You could even inherit from our Ribbit theme!

**Challenge 4**
> **Different Action Bar Customizations**
> 
> We used a generator to customize our Action Bar, but play around with some of the attributes on your own to learn more about customizing specific parts of the Action Bar. If you completed the previous Extra Credit Challenge about creating a new custom theme, add Action Bar customizations to that.

**Challenge 5**
> **Defining Layouts in Code**
> 
> We don't need to use XML layouts to design our screens. See if you can recreate the ListView item layout in code instead of XML. The basics for doing so are covered in the "Defining a Relative Layout Programmatically" section of [this blog post](http://code.tutsplus.com/tutorials/android-user-interface-design-relative-layouts--mobile-4301).

**Challenge 6**
> **Fun with GridViews**
> 
> This extra credit challenge is to simply [read up on GridViews](http://developer.android.com/guide/topics/ui/layout/gridview.html) and try to create a fun and interesting grid layout different from the 3-column view we are using in the project.

**Challenge 7**
> **Fancy Checkmarks**
> 
> When we add a checkmark in the GridView, we are simply showing or hiding it. Instead, see if you can use an Animation or Transition to animate the checkmark, like sliding it on and off vertically.

**Challenge 8**
> **Tracking Notifications**
> 
> Parse includes some analytics functionality to [track user engagement with push notifications](https://parse.com/docs/push_guide#receiving-tracking/Android). Implement this in Ribbit.

---
---
---
---

#GeoQuiz
**Challenge**

> Cheaters never win. Unless, of course, they persistently circumvent your anti-cheating measures. Which they probably will. Because they are cheaters.
> GeoQuiz has a few major loopholes. For this challenge, you will busy yourself with closing them. Here the loopholes are in ascending order, from easiest to hardest to close:
> 
> - Users can rotate **CheatActivity** after they cheat to clear out the cheating result.
> - Once they get back, users can rotate QuizActivity to clear out mIsCheater.
> - Users can press Next until the question they cheated on comes back around.
