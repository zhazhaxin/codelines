# Gradle 代码统计插件

## 使用方法

 - 在 project 或者 需统计 module 的 `build.gradle` 文件中添加

```
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.lemon:code-lines-plugin:1.3'
    }
}

apply plugin: 'code-lines'
```

 - 在需统计的 module 的 `build.gradle` 添加

```
codeLinesExtension {
    dir = 'demo/src'  // 统计的路径
    suffixs = ['.java', '.xml']  // 统计的文件类型
}
 ```

 - 最后在 Terminal 中 执行 `gradle codeLines`