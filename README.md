---
services:
platforms:
author: azure
---

﻿# Android - Mobile Services - Feedback
This is a feedback sample which makes use of Windows Azure Mobile Services for it's data storage.  It can be used as a feedback form inside of an application.  It can also be easily added to an existing Android project.  This sample was built using Eclipse, the Android SDK, and the Andorid Mobile Services SDK.  It was built using a minimum SDK version of 8 and a target version of 17.

Below you will find requirements and deployment instructions.

## Requirements
* Eclipse - This sample was built with Eclipse Indigo.
* Android SDK - You can download this from the [Android Developer portal](http://developer.android.com/sdk/index.html).
* Windows Azure Account - Needed to create and run the Mobile Service.  [Sign up for a free trial](https://www.windowsazure.com/en-us/pricing/free-trial/).

## Source Code Folders
* /source/start - This contains code for the application prior to adding in Mobile Services.
* /source/end - This contains code for the application with Mobile Services and requires client side changes noted below.

## Additional Resources
A blog post has gone up talking about this Feedback sample as well as how to connect multiple clients to the same Mobile Service backend.  You can read it [here](http://chrisrisner.com/Connecting-Multiple-Clients-to-the-Same-Mobile-Service).

#Setting up your Mobile Service
After creating your Mobile Service in the Windows Azure Portal, you'll need to create a table named "Feedback".

#Client Application Changes
In order to run the client applicaiton, you'll need to change a few settings in your application.  After importing the project into Eclipse, open FeedbackService.java file.  In the constructor method, change the \<YourMobileServiceUrl> and \<YourApplicationKey> to match the values from the Mobile Service you've created.

## Contact

For additional questions or feedback, please contact the [team](mailto:chrisner@microsoft.com).