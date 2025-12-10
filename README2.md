1、切换到 java 21
2、修改 gradle.properties，参考 idea about 修改如下字段：

    pluginSinceBuild
    pluginUntilBuild
    pluginVerifierIdeVersions
    platformVersion

3、如果 IDEA 的 kotlin 有升级，可以修改 libs.versions.toml 中对应的版本号

4、./gradlew build

自定义配置文件位于 $idea.config.path/custom_package.txt