package ci.nsu.moble.main

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    data class ColorItem(
        val name: String,
        val hexCode: String,
        val displayName: String
    )


    private val colorList = listOf(
        ColorItem("red", "#FF0000", "Red"),
        ColorItem("orange", "#FFA500", "Orange"),
        ColorItem("yellow", "#FFFF00", "Yellow"),
        ColorItem("green", "#00FF00", "Green"),
        ColorItem("blue", "#0000FF", "Blue"),
        ColorItem("indigo", "#4B0082", "Indigo"),
        ColorItem("violet", "#EE82EE", "Violet"),
        ColorItem("black", "#000000", "Black"),
        ColorItem("white", "#FFFFFF", "White"),
        ColorItem("pink", "#FFC0CB", "Pink"),
        ColorItem("purple", "#800080", "Purple"),
        ColorItem("brown", "#A52A2A", "Brown"),
        ColorItem("cyan", "#00FFFF", "Cyan"),
        ColorItem("magenta", "#FF00FF", "Magenta"),
        ColorItem("gray", "#808080", "Gray"),
        ColorItem("gold", "#FFD700", "Gold"),
        ColorItem("silver", "#C0C0C0", "Silver")
    )


    private lateinit var mainLayout: LinearLayout
    private lateinit var colorEditText: EditText
    private lateinit var applyButton: Button
    private lateinit var colorsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViews()


        createColorPalette()


        setupListeners()
    }

    private fun initViews() {
        mainLayout = findViewById(R.id.mainLayout)
        colorEditText = findViewById(R.id.colorEditText)
        applyButton = findViewById(R.id.applyButton)
        colorsContainer = findViewById(R.id.colorsContainer)
    }

    private fun setupListeners() {

        applyButton.setOnClickListener {
            val colorName = colorEditText.text.toString().trim()

            if (colorName.isEmpty()) {
                Log.w("MainActivity", "Пустой ввод цвета")
                return@setOnClickListener
            }


            val colorItem = findColorByName(colorName)

            if (colorItem == null) {
                Log.w("MainActivity", "Пользовательский цвет '$colorName' не найден")
            } else {
                applyColorToButton(colorItem)
            }
        }
    }

    private fun findColorByName(name: String): ColorItem? {
        return colorList.find {
            it.name.equals(name, ignoreCase = true) ||
                    it.displayName.equals(name, ignoreCase = true)
        }
    }

    private fun applyColorToButton(colorItem: ColorItem) {
        try {
            applyButton.setBackgroundColor(Color.parseColor(colorItem.hexCode))

            applyButton.setTextColor(getContrastColor(colorItem.hexCode))

            Log.i("MainActivity", "Цвет '${colorItem.displayName}' применен к кнопке")
        } catch (e: IllegalArgumentException) {
            Log.e("MainActivity", "Некорректный HEX код: ${colorItem.hexCode}")
        }
    }

    private fun getContrastColor(hexColor: String): Int {
        return try {
            val color = Color.parseColor(hexColor)
            val luminance = 0.299 * Color.red(color) +
                    0.587 * Color.green(color) +
                    0.114 * Color.blue(color)

            if (luminance > 186) Color.BLACK else Color.WHITE
        } catch (e: Exception) {
            Color.WHITE
        }
    }

    private fun createColorPalette() {
        colorsContainer.removeAllViews()

        val paletteTitle = TextView(this).apply {
            text = "Палитра цветов:"
            textSize = 18f
            setTextColor(Color.BLACK)
            setPadding(0, 20, 0, 10)
        }
        colorsContainer.addView(paletteTitle)

        for (colorItem in colorList) {
            val colorView = createColorView(colorItem)
            colorsContainer.addView(colorView)
        }
    }

    private fun createColorView(colorItem: ColorItem): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(0, 8, 0, 8)

            val colorPreview = TextView(this@MainActivity).apply {
                layoutParams = LinearLayout.LayoutParams(60, 60).apply {
                    marginEnd = 16
                }
                try {
                    setBackgroundColor(Color.parseColor(colorItem.hexCode))
                } catch (e: Exception) {
                    setBackgroundColor(Color.GRAY)
                }
            }

            val colorName = TextView(this@MainActivity).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                text = "${colorItem.displayName} (${colorItem.hexCode})"
                textSize = 16f
                setTextColor(Color.BLACK)

                // Обработчик клика на цвет в палитре
                setOnClickListener {
                    // Вставляем название цвета в поле ввода
                    colorEditText.setText(colorItem.name)

                    // Автоматически применяем цвет к кнопке
                    applyColorToButton(colorItem)

                    Log.i("MainActivity", "Выбран цвет из палитры: ${colorItem.displayName}")
                }
            }

            // Добавляем элементы в layout
            addView(colorPreview)
            addView(colorName)
        }
    }
}