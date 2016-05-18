# Self-Adaptive-Face-Detection-Service
An Android library project that implements face detection and feature analysis on images and videos.

## Abstract:
Face detection is a classic problem in Computer Vision. It consists on identifying human faces in digital images and videos. With the proliferation of mobile and camera-equipped devices, face detection technologies are being used in a variety of applications including biometry, augmented reality, photography and marketing. Face detection techniques were usually distributed in the form of software libraries like OpenCV, but nowadays many solutions are provided as Web services. 

The proposed service wraps and composes third-part face detection services throw a single interface to use for developing Android apps. The library switch alternatives dynamically considering context changes and user preferences regarding functional and non-functional requirements. This adaptation is done with an innovative approach that select and compose services using feature models.

## Included components:
- Android services:
  - Viola-Jones detector with OpenCV
  - Google Play Services Face API

- Web services:
  - Face Rect API
  - Sky Biometry API
  - Project Oxford Face API

TO DO

