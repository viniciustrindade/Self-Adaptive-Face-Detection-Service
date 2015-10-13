# Context-Aware-Face-Detection-Library
An Android library project that implements Face Detection services as a composition of Android and Web services.

## Abstract:
Face detection is a classic problem in Computer Vision. It consists on identifying human faces in digital images and videos. 
With the proliferation of mobile and camera-equipped devices, face detection technologies
are being used in a variety of applications including biometry, augmented
reality, photography and marketing. Face detection techniques were usually distributed in the form of software libraries like OpenCV, but nowadays many solutions are provided as Web services. 

The proposed library wraps and compose Face Detection service providers throw a single interface to use
for developing Android apps. The library switch providers dynamically
considering context changes and user preferences regarding functional and
non-functional requirements. This adaptation is done with an innovative
approach that select and compose services using feature models.

## Included providers:
- Android services:
-- OpenCV Manager
-- Google Play Services Face API

- Web services:
-- Face Rect
-- Sky Biometry
-- Project Oxford

