package daos;

import entities.Evaluare;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class EvaluareDao {
    private Map<Integer, Evaluare> evaluareDB;

    public EvaluareDao(Map<Integer, Evaluare> evaluareDB) {
        this.evaluareDB = evaluareDB;
    }

    public void save (Evaluare evaluare){
        evaluareDB.put(evaluare.getIdEvaluare(),evaluare);
    }

    public void delete (Integer idEvaluare){
        evaluareDB.remove(idEvaluare);
    }

    public List<Evaluare> getEvaluari(Integer idUser){
        List<Evaluare> ret = new ArrayList<>();

        for(Map.Entry<Integer, Evaluare> entry: evaluareDB.entrySet()){

        Evaluare evaluare = entry.getValue();

        if(evaluare.getUser().getIdUser() == idUser)
            ret.add(evaluare);
        }

        return ret;
    }
}


