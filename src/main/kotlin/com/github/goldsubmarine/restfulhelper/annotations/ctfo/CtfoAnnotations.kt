package com.github.goldsubmarine.restfulhelper.annotations.ctfo

import com.intellij.openapi.application.PathManager
import com.intellij.psi.PsiAnnotation
import java.io.File

//val CTFO_PACKAGE_NAME = "com.ctfo.platform.web.scanner.annotation"
val configPath = PathManager.getConfigPath()  // 获取 idea.config.path 的值
val filePath = "$configPath/custom_package.txt"    // 构建相对路径
var CTFO_PACKAGE_NAMES: List<String> = loadPackageNames(filePath)
// 读取文件内容并返回包名列表
fun loadPackageNames(filePath: String): List<String> {
    val file = File(filePath)
    return if (file.exists() && file.canRead()) {
        file.readLines()
    } else {
        println("文件不存在或无法读取")
        emptyList()
    }
}
class GetResource(psiAnnotation: PsiAnnotation) : ApiResource(psiAnnotation) {
    override fun extractMethod() = "GET"
}

class PostResource(psiAnnotation: PsiAnnotation) : ApiResource(psiAnnotation) {
    override fun extractMethod() = "POST"
}

open class ApiResource(psiAnnotation: PsiAnnotation) : CtfoResourceAnnotation(psiAnnotation) {
    override fun extractMethod(): String {
        val valueParam = psiAnnotation.findAttributeValue("method")
        if (valueParam != null && valueParam.text.isNotBlank() && "{}" != valueParam.text) {
            return valueParam.text.replace("RequestMethod.", "")
        }
        return "GET"
    }
}