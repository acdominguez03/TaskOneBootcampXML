package com.example.taskonebootcampxml.presentation.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState: MutableStateFlow<HomeState> by lazy { MutableStateFlow(HomeState()) }
    val uiState = _uiState.asStateFlow()

    private val texts: ArrayList<String> = arrayListOf(
        "Una mañana, tras un sueño intranquilo, Gregorio Samsa se despertó convertido en un monstruoso insecto. Estaba echado de espaldas sobre un duro caparazón y, al alzar la cabeza, vio su vientre convexo y oscuro, surcado por curvadas callosidades, sobre el que casi no se aguantaba la colcha, que estaba a punto de escurrirse hasta el suelo. Numerosas patas, penosamente delgadas en comparación con el grosor normal de sus piernas, se agitaban sin concierto. - ¿Qué me ha ocurrido? No estaba soñando. Su habitación, una habitación normal, aunque muy pequeña, tenía el aspecto habitual. Sobre la mesa había desparramado un muestrario",
        "Quiere la boca exhausta vid, kiwi, piña y fugaz jamón. Fabio me exige, sin tapujos, que añada cerveza al whisky. Jovencillo emponzoñado de whisky, ¡qué figurota exhibes! La cigüeña tocaba cada vez mejor el saxofón y el búho pedía kiwi y queso. El jefe buscó el éxtasis en un imprevisto",
        "Reina en mi espíritu una alegría admirable, muy parecida a las dulces alboradas de la primavera, de que gozo aquí con delicia. Estoy solo, y me felicito de vivir en este país, el más a propósito para almas como",
        "Y, viéndole don Quijote de aquella manera, con muestras de tanta tristeza, le dijo: Sábete, Sancho, que no es un",
        "Muy lejos, más allá de las montañas de palabras, alejados",
        "Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues",
        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem",
        "El viento susurra secretos entre las hojas del árbol. El sol se esconde tímidamente detrás de las nubes grises. El mundo espera pacientemente su próximo capítulo.",
        "En el rincón oscuro de la habitación, un reloj marca el paso del tiempo con su tic-tac constante. Afuera, la lluvia golpea suavemente los cristales. Los libros se amontonan en estanterías, guardando historias olvidadas y sueños dormidos.",
        "En un campo verde y vasto, las flores bailan con la brisa matinal mientras los pájaros entonan su melodía. Un arroyo serpentea suavemente, reflejando los rayos del sol. A lo lejos, se yergue majestuosa una montaña, testigo silente del paso del tiempo. En la ciudad, el bullicio de la vida urbana se despliega: gente que corre de un lado a otro, autos que rugen en las calles. En medio de todo esto, un anciano observa desde su banco en el parque, sonriendo con la serenidad de quien ha visto el ciclo de la vida repetirse una y otra vez.",
        "Bajo el cielo estrellado, la ciudad duerme en silencio. Las luces parpadean como luciérnagas en la distancia. En algún lugar, una guitarra susurra notas de nostalgia. En las calles vacías, los recuerdos danzan con sombras fugaces. El viento lleva consigo susurros de historias olvidadas mientras la noche abraza al mundo con su manto oscuro.",
        "El río serpenteaba entre los árboles, reflejando el cielo azul. A lo lejos, los pájaros cantaban su melodía matutina.",
        "En el jardín, las rosas despliegan sus pétalos, embriagando el aire con su fragancia. El sol se cuela entre las ramas, pintando el suelo de sombras danzantes. En este rincón de serenidad, el tiempo se detiene, permitiendo un breve instante de eterna belleza natural.",
        "Bajo el fulgor del crepúsculo, el río fluía mansamente, reflejando destellos dorados. A lo lejos, las montañas se recortaban contra el cielo anaranjado. El susurro del viento entre los árboles acompañaba el canto de los pájaros. En este escenario de serenidad, el alma se sumerge en la calma del momento, olvidando las preocupaciones del mundo por un breve instante de paz etérea.",
        "En el corazón del bosque, entre la espesura de los árboles milenarios, un arroyo canta su canción eterna. Los rayos del sol se filtran entre las hojas, pintando un tapiz de sombras y luces danzantes sobre el suelo cubierto de musgo. El aroma fresco de la tierra mojada llena los sentidos, mientras el viento susurra secretos ancestrales. Aquí, en este santuario natural, el tiempo se detiene y el alma encuentra su verdadero hogar.",
        "Bajo el dosel de un cielo estrellado, dos almas se entrelazan en un baile de palabras y miradas cómplices. El susurro del viento acaricia sus rostros mientras comparten secretos bajo la luz de la luna. En ese instante efímero, el universo se detiene, y solo existe el latido de dos corazones sincronizados en armonía.",
        "Las olas rompen suavemente en la orilla, mientras el sol se oculta detrás del horizonte. Las gaviotas danzan en el cielo naranja, pintando un cuadro de paz y serenidad.",
        "En la ciudad bulliciosa, los transeúntes se apresuran entre edificios de cristal y acero. El rumor de la vida urbana se mezcla con el aroma a café de las cafeterías, creando un telón de fondo vibrante y enérgico.",
        "Bajo el cielo estrellado, el rumor del mar acaricia la playa, susurrando melodías ancestrales. Las hogueras iluminan rostros sonrientes mientras las historias se entrelazan en la noche. La brisa marina trae consigo aromas de sal y aventura, mientras las estrellas titilan en el firmamento como faros perdidos en la inmensidad. En este instante efímero, el tiempo se desvanece y solo queda la magia del momento, eternizada en el corazón de quienes lo viven.",
        "El sol brilla en silencio."
    )

    private fun randomText() {
        _uiState.tryEmit(
            _uiState.value.copy(
                randomText = texts.random()
            )
        )
    }

    fun randomNumber(): Int {
        randomText()
        return Random.nextInt(2)
    }

}

data class HomeState(
    val randomText: String = "",
    val randomNumber: Int = 0
)