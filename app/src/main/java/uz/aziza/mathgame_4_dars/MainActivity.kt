package uz.aziza.mathgame_4_dars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.widget.addTextChangedListener
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    private lateinit var myTextView: TextView
    private lateinit var myEditText: EditText
    private lateinit var myScoreTv:TextView

    var number1:Int = 0
    var number2:Int = 0
    var amal = 0
    var tJavob:Int = 0

    var totalScore = 0
    var correctScore = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myTextView = findViewById(R.id.tv_1)
        myEditText = findViewById(R.id.edt_1)
        myScoreTv = findViewById(R.id.tv_ball)



        randomMisol()



        myEditText.addTextChangedListener {
            if (tJavob.toString().length == it?.length){
                val javob = myEditText.text.toString().toInt()
                if (javob == tJavob) {
                    correctScore++
                    Toast.makeText(this, "To'g'ri javob", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Noto'g'ri javob", Toast.LENGTH_SHORT).show()
                }
                totalScore++
                myEditText.text.clear()
                randomMisol()
            }
        }
    }
        fun randomMisol(){
            number1 = Random.nextInt(20)
            number2 = Random.nextInt(20)

            if (number1<number2){
                randomMisol()
                return
            }

            amal = Random.nextInt(4)

            when(amal){
                0 ->{
                    tJavob = number1+number2
                    myTextView.text = "$number1 + $number2 ="
                }
                1->{
                    if (number1<number2){
                        randomMisol()
                        return
                    }
                    tJavob = number1-number2
                    myTextView.text = "$number1 - $number2 ="
                }
                2->{
                    tJavob = number1*number2
                    myTextView.text = "$number1 * $number2 ="
                }
                3->{
                    try {
                        if (number1%number2!=0){
                            randomMisol()
                            return
                        }
                        tJavob = number1/number2
                        myTextView.text = "$number1 : $number2 ="
                    }catch (e:Exception){
                        randomMisol()
                    }

                }
            }
            myScoreTv.text = "$correctScore / $totalScore"
        }
}