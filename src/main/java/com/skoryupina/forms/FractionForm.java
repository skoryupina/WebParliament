package com.skoryupina.forms;

import com.skoryupina.entities.Fraction;
import com.skoryupina.entities.Party;
import com.sun.istack.internal.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FractionForm {
    private Integer id;
    private String name;
    private Map<Party, Boolean> parties = new HashMap<>();

    //region getters_and_setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Map<Party, Boolean> getParties() {
        return parties;
    }

    public void setParties(@Nullable Set<Party> partiesInFraction, @Nullable Iterable<Party> partiesInWebParliament) {
        if (partiesInFraction == null || partiesInFraction.size()==0) {
            for (Party party : partiesInWebParliament) {
                parties.put(party, false);
            }
        }else {
            for (Party party : partiesInWebParliament) {
                parties.put(party, partiesInFraction.contains(party));
            }
        }
    }
    //endregion

    public void feed(Fraction fraction, Iterable<Party> partiesInWebParliament) {
        setId(fraction.getId());
        setName(fraction.getName());
        setParties(fraction.getParties(), partiesInWebParliament);
    }
}
