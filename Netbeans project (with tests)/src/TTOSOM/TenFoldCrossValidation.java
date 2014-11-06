/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TTOSOM;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.core.Instances;

/**
 *
 *  This class extends from Validation and represents the implementation of cross validation (10 fold).
 * 
 * @author Franzel Madariaga
 */
public class TenFoldCrossValidation extends Validation{
    private int folds;
    private Random random;
    private Instances dataSet;

    public TenFoldCrossValidation(int folds, Random random, String validationType, TTOSOM ttosom, Instances dataSet) {
        super(validationType, ttosom, dataSet);
        this.folds = folds;
        this.random = random;
        this.dataSet = dataSet;
        
        TTOSOM ttosom_validation = this.getTtosom();
        Evaluation eval = this.getEval();
            
        try {
            eval.crossValidateModel(ttosom_validation, dataSet,folds, random);
        } catch (Exception ex) {
            Logger.getLogger(TenFoldCrossValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        this.setEval(eval);
        
    }
    
    
    
    
}
