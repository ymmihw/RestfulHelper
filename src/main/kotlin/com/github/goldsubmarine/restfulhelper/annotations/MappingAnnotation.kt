package com.github.goldsubmarine.restfulhelper.annotations

import com.intellij.psi.PsiAnnotation
import com.github.goldsubmarine.restfulhelper.RequestMappingItem
import com.github.goldsubmarine.restfulhelper.annotations.ctfo.ApiResource
import com.github.goldsubmarine.restfulhelper.annotations.ctfo.GetResource
import com.github.goldsubmarine.restfulhelper.annotations.ctfo.PostResource
import com.github.goldsubmarine.restfulhelper.annotations.jaxrs.DELETE
import com.github.goldsubmarine.restfulhelper.annotations.jaxrs.GET
import com.github.goldsubmarine.restfulhelper.annotations.jaxrs.HEAD
import com.github.goldsubmarine.restfulhelper.annotations.jaxrs.OPTIONS
import com.github.goldsubmarine.restfulhelper.annotations.jaxrs.PATCH
import com.github.goldsubmarine.restfulhelper.annotations.jaxrs.POST
import com.github.goldsubmarine.restfulhelper.annotations.jaxrs.PUT
import com.github.goldsubmarine.restfulhelper.annotations.micronaut.Delete
import com.github.goldsubmarine.restfulhelper.annotations.micronaut.Get
import com.github.goldsubmarine.restfulhelper.annotations.micronaut.Head
import com.github.goldsubmarine.restfulhelper.annotations.micronaut.Options
import com.github.goldsubmarine.restfulhelper.annotations.micronaut.Patch
import com.github.goldsubmarine.restfulhelper.annotations.micronaut.Post
import com.github.goldsubmarine.restfulhelper.annotations.micronaut.Put
import com.github.goldsubmarine.restfulhelper.annotations.spring.DeleteMapping
import com.github.goldsubmarine.restfulhelper.annotations.spring.GetMapping
import com.github.goldsubmarine.restfulhelper.annotations.spring.PatchMapping
import com.github.goldsubmarine.restfulhelper.annotations.spring.PostMapping
import com.github.goldsubmarine.restfulhelper.annotations.spring.PutMapping
import com.github.goldsubmarine.restfulhelper.annotations.spring.RequestMapping

interface MappingAnnotation {

    fun values(): List<RequestMappingItem>

    companion object {
        val supportedAnnotations = listOf(
            RequestMapping::class.java.simpleName,
            GetMapping::class.java.simpleName,
            PostMapping::class.java.simpleName,
            PutMapping::class.java.simpleName,
            PatchMapping::class.java.simpleName,
            DeleteMapping::class.java.simpleName,

            GET::class.java.simpleName,
            PUT::class.java.simpleName,
            POST::class.java.simpleName,
            OPTIONS::class.java.simpleName,
            HEAD::class.java.simpleName,
            DELETE::class.java.simpleName,
            PATCH::class.java.simpleName,

            Delete::class.java.simpleName,
            Get::class.java.simpleName,
            Head::class.java.simpleName,
            Options::class.java.simpleName,
            Patch::class.java.simpleName,
            Post::class.java.simpleName,
            Put::class.java.simpleName,

            PostResource::class.java.simpleName,
            GetResource::class.java.simpleName,
            ApiResource::class.java.simpleName,
        )

        fun mappingAnnotation(annotationName: String, psiAnnotation: PsiAnnotation): MappingAnnotation {
            return when (annotationName) {
                RequestMapping::class.java.simpleName -> RequestMapping(psiAnnotation)
                GetMapping::class.java.simpleName -> GetMapping(psiAnnotation)
                PostMapping::class.java.simpleName -> PostMapping(psiAnnotation)
                PutMapping::class.java.simpleName -> PutMapping(psiAnnotation)
                PatchMapping::class.java.simpleName -> PatchMapping(psiAnnotation)
                DeleteMapping::class.java.simpleName -> DeleteMapping(psiAnnotation)

                GET::class.java.simpleName -> GET(psiAnnotation)
                PUT::class.java.simpleName -> PUT(psiAnnotation)
                POST::class.java.simpleName -> POST(psiAnnotation)
                OPTIONS::class.java.simpleName -> OPTIONS(psiAnnotation)
                HEAD::class.java.simpleName -> HEAD(psiAnnotation)
                DELETE::class.java.simpleName -> DELETE(psiAnnotation)
                PATCH::class.java.simpleName -> PATCH(psiAnnotation)

                Get::class.java.simpleName -> Get(psiAnnotation)
                Put::class.java.simpleName -> Put(psiAnnotation)
                Post::class.java.simpleName -> Post(psiAnnotation)
                Options::class.java.simpleName -> Options(psiAnnotation)
                Head::class.java.simpleName -> Head(psiAnnotation)
                Delete::class.java.simpleName -> Delete(psiAnnotation)
                Patch::class.java.simpleName -> Patch(psiAnnotation)

                PostResource::class.java.simpleName -> PostResource(psiAnnotation)
                GetResource::class.java.simpleName -> GetResource(psiAnnotation)
                ApiResource::class.java.simpleName -> ApiResource(psiAnnotation)

                else -> UnknownAnnotation
            }
        }
    }
}
