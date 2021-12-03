# myFirstApp **(paL)**
myFirstApp **(paL)** is an Android Studio app, created as a guided project during the first trimester of my User Interface Design class using Material Design guidelines and components.

# Activities
paL has 6 activities: 
- Splash
- Login
- Signup
- Forgot (password)
- Main
- Bookmarked

## Splash
Splash has two animations, one on each image, when they finish they lead to the Login activity. The images are loaded with Glide.

&nbsp;
<img src="img\Splash.gif"> </img>
## Login
Login has two TextViews for the username and password (with a toggle/visible button), two buttons that lead to Main(SIGNIN), Signup and a TextView that leads to Forgot("I forgot my password").

&nbsp;
<img src="img\Login.jpg"> </img>
## Signup
Signup has some TextViews and a button that, when clicked on, sends you to Login activity and shows a Toast message.

&nbsp;
<img src="img\Signup.gif"> </img>
## Forgot
Forgot has a TextView and a button, just as the Signup activity, when the button is clicked on, it sends you to Login activity and shows a Toast message.

&nbsp;
<img src="img\Forgot.gif"> </img>
## Main

&nbsp;
<img src="img\Main.gif"> </img>
The Main activity layout consists of:
- WebView
- Appbar menu 
- Swipe-to-Refresh
### WebView
The WebView loads a random Wikipedia article using a link (https://en.wikipedia.org/wiki/Special:Random). The default link shows a random article from the english Wikipedia.
### Swipe-to-Refresh
When swipped down, it loads the URL to deliver a new random article

&nbsp;
<img src="img\Swipe.gif"> </img>
### Appbar Menu
It has four items:
- Language: When clicked on, it shows you an Alert Dialog that lets you pick between english and spanish. It changes the language bit on the Wikipedia link from 'en' to 'es' or the other way around.

&nbsp;
<img src="img\Lang.gif"> </img>
- Signout: Shows an Alert Dialog that lets you choose if you want to stay in the app or signout. If 'YES' is clicked, it loads the Main activity.

&nbsp;
<img src="img\Signout.gif"> </img>
- Bookmark: Copies current WebView's URL to ArrayList you can consult clicking on the `Bookmarks` item. Shows a Toast message.
- Bookmarks: Leds you to `Bookmarked activity`.
<!--Bookmark-->
## Bookmarked
This activity layout consists of a RecyclerView that shows the ArrayList where the WebView's URL are being saved on the previous activity, like a library.

&nbsp;
<img src="img\Bookmarked.gif"> </img>
# Other characteristics
- There are restrictions preventing the user to go back to the Splash activity from the Login activity using the back button, aswell as going back to the Login activity from the Main activity.
- All activities have layouts designed both for portrait and landscape mode.



