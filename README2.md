1、 切换到 java 21
2、修改 gradle.properties，参考 idea about 修改如下字段：

    pluginSinceBuild
    pluginUntilBuild
    pluginVerifierIdeVersions
    platformVersion

2、./gradlew build

自定义配置文件位于 $idea.config.path/custom_package.txt