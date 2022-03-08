package com.th.operation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.th.model.Train;

public class TrainDAO {
	
	public Train findTrain(int no) {		
		Connection con = DBManager.getConnection();
        Train train = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from trains where train_no =" + no);
            while(rs.next()){
            		if(no!=rs.getInt(1)) {
            			return null;
            		}else {
	                    int trainNO = rs.getInt(1);
	                    String trainName = rs.getString(2);
	                    String source = rs.getString(3);
	                    String destination = rs.getString(4);
	                    double price = rs.getDouble(5);
	                    train = new Train(trainNO,trainName,source,destination,price);
            		}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return train;		
	}
}
