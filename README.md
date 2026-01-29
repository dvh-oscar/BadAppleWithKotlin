
- [한국어](README-KR.md)

---

> *If it exists, you can play Bad Apple on it.*

I want do that by Kotlin.

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
```shell
java -jar BadAppleWithKotlin.jar print <frames_folder> <fps> <clear_command>
```
- `frame_folder` : the `output_folder` that 'Generate frames'. The folder should not contains non-ASCII art txt file.
- `fps` : frame per second. greater then 0, real number.
- `clear_command` : the console command that you want clear it. maybe `clear` or `cls`