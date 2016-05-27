# Gradleを使ったJavaプロジェクトのテンプレート

## セットアップ

```
git clone https://github.com/aoyama-val/javaTemplateGradle.git
cd javaTemplateGradle
# gradleをインストールし、
# .project, .classpath, .settingsを生成する
./gradlew eclipse
```

その後Eclipseで「File -> Import -> Existing Projects into Workspace」でインポートし、さらに「File -> Import -> Gradle Project」でGradleプロジェクトとしてインポートする。


## コマンドラインからのgradle使用方法

タスク一覧表示

```
./gradlew tasks
```

ビルド

```
./gradlew build
```

JAR作成のみ

```
./gradlew jar
```


## メモ

.project, .classpath, .settingsは`./gradlew eclipse`で作成でき、絶対パスを含むためgitには入れない方がいいらしい。

新規にgradleプロジェクトを作成するときはEclipseのプラグインを使うより

```
mkdir p1
cd p1
gradle init
# 生成されたbuild.gradleにapply plugin: 'eclipse'を追記し、コメントアウトされている部分を解除
./gradlew eclipse
```

そしてEclipseにインポートという手順の方が何をしているか分かりやすくていいかもしれない。
