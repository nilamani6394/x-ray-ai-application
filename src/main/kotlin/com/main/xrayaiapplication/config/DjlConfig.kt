package com.main.xrayaiapplication.config

import ai.djl.modality.Classifications
import ai.djl.modality.cv.util.NDImageUtils
import ai.djl.ndarray.NDArray
import ai.djl.ndarray.NDArrays
import ai.djl.ndarray.NDList
import ai.djl.translate.Batchifier
import ai.djl.translate.Translator
import ai.djl.translate.TranslatorContext
import org.springframework.context.annotation.Configuration
import java.awt.image.BufferedImage

@Configuration
class DjlConfig{
    class XrayTranslator: Translator<BufferedImage,Classifications> {
        override fun processInput(ctx: TranslatorContext?, input: BufferedImage?): NDList {
//            var array:NDArray =
            return NDList()
        }

        override fun processOutput(ctx: TranslatorContext?, list: NDList?): Classifications {
            TODO("Not yet implemented")
        }

        override fun getBatchifier(): Batchifier {
//            https://github.com/davidkiss/djl-spring-boot-xray/blob/master/pom.xml
//            https://dzone.com/articles/deep-learning-with-spring-boot-and-djl
            return batchifier
        }

    }

}

