
- [한국어](README-KR.md)

---

> *If it exists, you can play Bad Apple on it.*

I want do that by Kotlin. [![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)](https://youtu.be/gzyMeUIUHbE)

This console application based on Java 21.

If you provide video file, this application generate 8-dot braille ASCII art, and print it console.

This application DOES NOT INCLUDE `Bad Apple!`. If you want play it, provide video file.

# Generate frames
The video should be white-black.
```shell
java -jar BadAppleWithKotlin.jar generate <video> <output_folder> <scale>
```
- `video` : The video file's path that you want convert. It can be the `Bad_apple.mp4`
- `output_folder` : generated ASCII arts text files will save.
- `scale` : greater then 0. If you input big value, output frame will going to small.

# Play
Play ASCII arts on console
> This feature doesn't work on Windows
```shell
java -jar BadAppleWithKotlin.jar print <frames_folder> <fps>
```
- `frame_folder` : the `output_folder` that 'Generate frames'. The folder should not contains non-ASCII art txt file.
- `fps` : frame per second. greater then 0, real number.

---

# Do you want it build yourself?
Lots of test functions won't pass on your environment.
```shell
./gradlew build -x test
```
