- [English](README.md)

---

# 소개
> *화면이 있다면 배드애플을 틀어라.*

저는 그것을 Kotlin 으로 하고 싶었습니다.

이 애플리케이션은 Java 21로 개발하엿고, 명령줄에서 실행하는 애플리케이션입니다.

영상을 입력받아 JavaCV 라이브러리를 이용하여 8점 점자를 이용한 ASCII art로 처리하고,
그것을 명령창에 출력합니다.

이 애플리케이션에는 `Bad Apple!` 이 포함되어 있지 않으며, 사용자는 변환하고자 하는 영상 파일을 가지고 있어야 합니다.

# 점자 변환
주어진 영상의 각 프레임을 8점 점자를 이용한 ASCII Art로 나타애어 텍스트 파일로 저장합니다. 
입력받은 영상은 흑백이라 가정합니다.
```shell
java -jar BadAppleWithKotlin.jar generate <video> <output_folder> <scale>
```
- `video` : 점자로 바꾸고자 하는 영상 파일. 이를테면 `./video/Bad_Apple.mp4`
- `output_folder` : ASCII Art 로 나타낸 프레임 텍스트 파일이 저장될 폴더
- `scale` : 0을 초과하는 실수여야 합니다. 이 값이 클수록 작은 ASCII Art로 변환됩니다.

# 재생
여러 장의 ASCII ART를 재생합니다.
> 이 기능은 윈도우에서 동작하지 않습니다.
```shell
java -jar BadAppleWithKotlin.jar print <frames_folder> <fps> <clear_command>
```
- `frame_folder` : '점자 변환' 단계에서 `output_folder` 로 지정한 폴더입니다. 해당 폴더에는 ASCII Art가 아닌 텍스트 파일이 있으면 안 됩니다.
- `fps` : 1초에 몇 프레임이 재생되어야 하는지에 대한 값입니다. 0을 초과하는 실수여야 합니다.