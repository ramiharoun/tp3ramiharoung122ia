package com.example.tp3ramiharoung122ia.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface GuideTouristique {

    @SystemMessage("""
        Tu agis comme un guide touristique francophone.
        Ta réponse doit être rédigée uniquement en JSON, sans texte additionnel.
        Elle doit comprendre :
        - le nom de la ville ou du pays demandé,
        - exactement {{nb}} lieux emblématiques à visiter,
        - le prix moyen d’un repas accompagné de la devise locale.
        Exemple de structure :
        {
          "ville_ou_pays": "nom",
          "endroits_a_visiter": ["site1", "site2"],
          "prix_moyen_repas": "valeur devise"
        }
        """)
    @UserMessage("Fournis les informations touristiques pour {{lieu}} avec {{nb}} endroits à visiter.")
    String guide(@V("lieu") String lieu, @V("nb") int nb);
}
