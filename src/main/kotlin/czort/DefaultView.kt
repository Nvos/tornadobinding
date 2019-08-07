package czort
import javafx.beans.property.SimpleStringProperty
import javafx.scene.Parent
import javafx.scene.control.Alert
import javafx.scene.control.TextField
import tornadofx.*

class ExampleModel(name: String? = null, title: String? = null) {
    val nameProperty = SimpleStringProperty(this, "name", name)
    var name by nameProperty

    val titleProperty = SimpleStringProperty(this, "title", title)
    var title by titleProperty
}

class DefaultView: View() {
    private val model = ExampleModel(title = "Bob", name = "Jeff")
    override val root = vbox {
        form {
            textfield("Name") {
                bind(model.nameProperty)
            }
            textfield("Title") {
                bind(model.titleProperty)
            }

            button("Do something") {
                setOnAction {
                    alert(Alert.AlertType.CONFIRMATION, "Saving title: ${model.title}, name: ${model.name}")
                }
            }
        }
    }
}