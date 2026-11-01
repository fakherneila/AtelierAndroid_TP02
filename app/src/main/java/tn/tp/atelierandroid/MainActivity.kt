package tn.tp.atelierandroid

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Collection privée pour stocker les participants
    private val participants = mutableListOf<Participant>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Récupération des composants existants (TP2)
        val etNom = findViewById<EditText>(R.id.etNom)
        val etPrenom = findViewById<EditText>(R.id.etPrenom)
        val etAge = findViewById<EditText>(R.id.etAge)
        val spGroupe = findViewById<Spinner>(R.id.spGroupe)
        val rgSupport = findViewById<RadioGroup>(R.id.rgSupport)
        val cbConfirmation = findViewById<CheckBox>(R.id.cbConfirmation)
        val btnAfficher = findViewById<Button>(R.id.btnAfficher)
        val btnEffacer = findViewById<Button>(R.id.btnEffacer)
        val tvResultat = findViewById<TextView>(R.id.tvResultat)

        // Nouveaux composants TP3
        val btnEnregistrer = findViewById<Button>(R.id.btnEnregistrer)
        val btnListe = findViewById<Button>(R.id.btnListe)
        val tvCompteur = findViewById<TextView>(R.id.tvCompteur)
        val etRecherche = findViewById<EditText>(R.id.etRecherche)
        val btnRechercher = findViewById<Button>(R.id.btnRechercher)

        // Fonction de lecture et validation (retourne un Participant ou null)
        fun lireParticipant(): Participant? {
            val nom = etNom.text.toString().trim()
            val prenom = etPrenom.text.toString().trim()
            val age = etAge.text.toString().toIntOrNull()
            val groupe = spGroupe.selectedItem.toString()
            val support = if (rgSupport.checkedRadioButtonId == R.id.rbEmulateur) "Émulateur" else "Téléphone"

            if (nom.isEmpty() || prenom.isEmpty()) {
                Toast.makeText(this, "Nom et prénom obligatoires", Toast.LENGTH_SHORT).show()
                return null
            }
            if (age == null || age !in 1..120) {
                Toast.makeText(this, "Âge invalide (1-120)", Toast.LENGTH_SHORT).show()
                return null
            }
            if (groupe == "Choisir un groupe") {
                Toast.makeText(this, "Choisissez un groupe", Toast.LENGTH_SHORT).show()
                return null
            }
            if (!cbConfirmation.isChecked) {
                Toast.makeText(this, "Confirmez les informations", Toast.LENGTH_SHORT).show()
                return null
            }

            return Participant(nom, prenom, age, groupe, support)
        }

        // BOUTON AFFICHER (existant TP2)
        btnAfficher.setOnClickListener {
            val p = lireParticipant()
            if (p != null) {
                tvResultat.text = p.fiche()
            }
        }

        // BOUTON ENREGISTRER (TP3)
        btnEnregistrer.setOnClickListener {
            val p = lireParticipant()
            if (p == null) return@setOnClickListener

            // Vérifier les doublons (même nom ET prénom, insensible à la casse)
            val doublon = participants.any {
                it.nom.equals(p.nom, ignoreCase = true) &&
                it.prenom.equals(p.prenom, ignoreCase = true)
            }

            if (doublon) {
                Toast.makeText(this, "Ce participant est déjà inscrit", Toast.LENGTH_SHORT).show()
            } else {
                participants.add(p)
                tvResultat.text = p.fiche()
                tvCompteur.text = "Inscriptions : ${participants.size}"
                Toast.makeText(this, "Participant enregistré", Toast.LENGTH_SHORT).show()
            }
        }

        // BOUTON LISTE (TP3)
        btnListe.setOnClickListener {
            if (participants.isEmpty()) {
                tvResultat.text = "Aucune inscription"
            } else {
                var affichage = ""
                for (p in participants) {
                    affichage += "${p.nom} ${p.prenom} (${p.groupe})\n"
                }
                tvResultat.text = affichage.trim()
            }
        }

        // BOUTON RECHERCHER (TP3)
        btnRechercher.setOnClickListener {
            val recherche = etRecherche.text.toString().trim()
            if (recherche.isEmpty()) {
                Toast.makeText(this, "Saisissez un nom à rechercher", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var trouve: Participant? = null
            for (p in participants) {
                if (p.nom.equals(recherche, ignoreCase = true)) {
                    trouve = p
                    break
                }
            }

            tvResultat.text = trouve?.fiche() ?: "Aucun participant trouvé"
        }

        // BOUTON EFFACER (existant TP2 modifié)
        btnEffacer.setOnClickListener {
            etNom.text.clear()
            etPrenom.text.clear()
            etAge.text.clear()
            spGroupe.setSelection(0)
            rgSupport.check(R.id.rbEmulateur)
            cbConfirmation.isChecked = false
            tvResultat.text = getString(R.string.resultat_initial)
            // Ne supprime PAS les participants
        }
    }
}