package movietime.core.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;

import movietime.core.card.Gold;
import movietime.core.card.RentalCard;
import movietime.core.creator.CreateCard;

public class DatabaseCard implements DatabaseCardInterface {

	private DefaultListModel<RentalCard> listCard;
	private CreateCard createCard;

	public DatabaseCard() {
		listCard = new DefaultListModel<RentalCard>();
		createCard = new CreateCard();
		createListCard();
	}

	@Override
	public DefaultListModel<RentalCard> getListCard() {
		return listCard;
	}

	@Override
	public void createListCard() {
		DataSource ds = new DataSource();
		Connection con = ds.connectDB();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "Select * from CARD;";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {

				int id_owner = rs.getInt("id_owner");

				int number = rs.getInt("number");
				String type = rs.getString("type");
				double credit = rs.getDouble("credit");
				int goldpoint = rs.getInt("goldpoint");

				RentalCard card = createCard.create(id_owner, number, credit, type);

				if (card instanceof Gold) {

					((Gold) card).getCollectionGoldPoint().setGoldPoint(goldpoint);
					listCard.addElement(card);
				} else {
					listCard.addElement(card);

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {

			try {

				con.close();

				st.closeOnCompletion();
				;

				rs.close();

			} catch (Exception exe) {
				exe.printStackTrace();
			}

		}

	}

	@Override
	public void addCard(RentalCard card) {
		listCard.addElement(card);
	}

	@Override
	public RentalCard getCard(int id_owner) {
		return listCard.getElementAt(id_owner);
	}

}
