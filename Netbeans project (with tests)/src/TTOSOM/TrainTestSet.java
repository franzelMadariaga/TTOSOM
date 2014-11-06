/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TTOSOM;

import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.core.Instances;

/**
 *
 * This class extends from Validation and represents the implementation of train test set.
 * 
 * @author Franzel Madariaga
 */
public class TrainTestSet extends Validation{
    Instances trainSet;
    Instances testSet;

    public TrainTestSet(String validationType, TTOSOM ttosom, Instances dataSet, Instances testSet) {
        super(validationType, ttosom, dataSet);
        this.trainSet = dataSet;
        this.testSet = testSet;
        
        try {
            TTOSOM ttosom_validation = this.getTtosom();
            Evaluation eval = this.getEval();
            
            ttosom_validation.buildClassifier(trainSet);
            eval.evaluateModel(ttosom_validation, testSet);
            this.setEval(eval);
            
        } catch (Exception ex) {
            Logger.getLogger(TrainTestSet.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    
    

    
    
}
