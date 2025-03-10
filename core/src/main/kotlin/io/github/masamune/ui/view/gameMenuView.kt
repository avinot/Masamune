package io.github.masamune.ui.view

import com.badlogic.gdx.scenes.scene2d.ui.Skin
import io.github.masamune.ui.model.GameMenuViewModel
import io.github.masamune.ui.widget.OptionTable
import io.github.masamune.ui.widget.optionTable
import ktx.scene2d.KTable
import ktx.scene2d.KWidget
import ktx.scene2d.Scene2dDsl
import ktx.scene2d.actor


@Scene2dDsl
class GameMenuView(
    model: GameMenuViewModel,
    skin: Skin,
) : View<GameMenuViewModel>(skin, model), KTable {

    private val optionTable: OptionTable

    init {
        setFillParent(true)
        optionTable = optionTable(skin) { cell ->
            background = skin.getDrawable("dialog_frame")
            cell.width(250f)
        }

        registerOnPropertyChanges()
    }

    override fun registerOnPropertyChanges() {
        viewModel.onPropertyChange(GameMenuViewModel::options) { options ->
            if (options.isEmpty()) {
                isVisible = false
                return@onPropertyChange
            }

            optionTable.clearOptions()
            options.forEach { optionTable.option(it) }
            optionTable.padTop(15f)
            isVisible = true
        }
    }

    override fun onDownPressed() {
        if (optionTable.nextOption()) {
            viewModel.playSndMenuClick()
        }
    }

    override fun onUpPressed() {
        if (optionTable.prevOption()) {
            viewModel.playSndMenuClick()
        }
    }

    override fun onSelectPressed() {
        viewModel.triggerOption(optionTable.selectedOption)
        if (optionTable.selectedOption == optionTable.numOptions - 1) {
            isVisible = false
        }
    }

    override fun onBackPressed() {
        viewModel.triggerClose()
    }
}

@Scene2dDsl
fun <S> KWidget<S>.gameMenuView(
    model: GameMenuViewModel,
    skin: Skin,
    init: (@Scene2dDsl GameMenuView).(S) -> Unit = {},
): GameMenuView = actor(GameMenuView(model, skin), init)
