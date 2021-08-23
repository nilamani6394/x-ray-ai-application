/**import ai.djl.modality.Classifications
import ai.djl.modality.cv.util.NDImageUtils
import ai.djl.ndarray.NDArray
import ai.djl.ndarray.NDList
import ai.djl.repository.zoo.ModelZoo
import ai.djl.repository.zoo.ZooModel
import ai.djl.translate.TranslatorContext
import java.awt.image.BufferedImage


class XrayTranslator : Translator<BufferedImage?, Classifications?> {
    fun processInput(ctx: TranslatorContext, input: BufferedImage?): NDList {
        var array: NDArray? = BufferedImageUtils.toNDArray(
            ctx.ndManager, input, NDImageUtils.Flag.COLOR
        )
        array = NDImageUtils.resize(array, 224).div(255.0f)
        return NDList(array)
    }

    fun processOutput(ctx: TranslatorContext?, list: NDList): Classifications {
        val probabilities = list.singletonOrThrow()
        return Classifications(CLASSES, probabilities)
    }

    companion object {
        private val CLASSES: List<String> = Arrays.asList("covid-19", "normal")
    }
}

@Bean
@Throws(Exception::class)
fun xrayModel(): ZooModel<*, *>? {
    val criteria: Criteria<BufferedImage, Classifications> = Criteria.builder()
        .setTypes(BufferedImage::class.java, Classifications::class.java)
        .optTranslator(XrayTranslator())
        .build()
    return ModelZoo.loadModel<Any, Any>(criteria)
}*/