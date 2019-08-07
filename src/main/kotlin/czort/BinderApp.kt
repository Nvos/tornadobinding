package czort

import javafx.application.Application
import tornadofx.App

class BinderApp: App(DefaultView::class)

fun main(args: Array<String>) {
    Application.launch(BinderApp::class.java, *args)
}