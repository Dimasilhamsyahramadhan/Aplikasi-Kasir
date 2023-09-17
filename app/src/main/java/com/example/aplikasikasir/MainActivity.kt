package com.example.aplikasikasir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.StrictMath.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val NamaPembeli = findViewById<EditText>(R.id.NamaPembeli)
        val NamaBarang = findViewById<EditText>(R.id.NamaBarang)
        val JumlahBeli = findViewById<EditText>(R.id.JumlahBeli)
        val Harga = findViewById<EditText>(R.id.Harga)
        val UangBayar = findViewById<EditText>(R.id.UangBayar)
        val btn = findViewById<Button>(R.id.BtnProses)
        val TotalBelanja = findViewById<TextView>(R.id.TotalBelanja)
        val Kembalian = findViewById<TextView>(R.id.UangKembalian)
        val Bonus = findViewById<TextView>(R.id.Bonus)
        val Keterangan = findViewById<TextView>(R.id.Keterangan)
        val btnReset = findViewById<Button>(R.id.BtnReset)

        btn.setOnClickListener{
            var total: Int = 0
            val jmlbeli = Integer.parseInt(JumlahBeli.text.toString())
            val hrg = Integer.parseInt(Harga.text.toString())
            val bayar = Integer.parseInt(UangBayar.text.toString())

            total = jmlbeli * hrg
            val kembali = bayar - total

            TotalBelanja.text = "Total Belanja:" + total.toString()
            Kembalian.text = "UangKembalian:" + kembali.toString()

            if (bayar == total) {
                Keterangan.text = "keterangan: kurang pas"
            }
            if (bayar < total) {
                Keterangan.text = "keterangan:  kurang bayar" + abs(kembali)
            }
            if (bayar > total) {
                Keterangan.text = "keterangan: kembali" + kembali
            }
            if (total >= 200000) {
                Bonus.text = "bonus:mouse"
            } else if (total >= 400000) {
                Bonus.text = "keyboard"
            } else if (total >= 600000) {
                Bonus.text = "hardisk"
            } else {
                Bonus.text = "bonus: tidak ada bonus"
            }

        }

        btnReset.setOnClickListener{
            NamaPembeli.setText("")
            NamaBarang.setText("")
            JumlahBeli.setText("")
            Harga.setText("")
            UangBayar.setText("")
            TotalBelanja.setText("total belanja")
            Kembalian.setText("uang kembalian")
            Bonus.setText("bonus")
            Keterangan.setText("keterangan")
        }
    }

}
