package a8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import comp401.sushi.*;

public class SushiWorkstationWidget extends JPanel implements ActionListener {

	private JComboBox sashimi_type;
	private JComboBox plate_type;
	private JComboBox nigiri_type;
	private JButton roll_button;
	private JButton sashimi_button;
	private JButton nigiri_button;
	private JSlider gold_price_slider;
	private JSlider avocado_slider;
	private JSlider crab_slider;
	private JSlider eel_slider;
	private JSlider rice_slider;
	private JSlider salmon_slider;
	private JSlider seaweed_slider;
	private JSlider shrimp_slider;
	private JSlider tuna_slider;

	private List<WorkstationListener> listeners;

	public SushiWorkstationWidget() {

		listeners = new ArrayList<WorkstationListener>();

		setLayout(new BorderLayout());

		JPanel roll_panel = new JPanel();
		roll_panel.setLayout(new GridLayout(10, 1));

		String[] plates = { "Gold Plate", "Blue Plate", "Green Plate",
				"Red Plate" };
		plate_type = new JComboBox(plates);
		roll_panel.add(new JLabel("Plate color: "));
		roll_panel.add(plate_type);

		gold_price_slider = new JSlider(500, 1500, 500);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(500), new JLabel("5.00"));
		labelTable.put(new Integer(1500), new JLabel("15.00"));
		gold_price_slider.setLabelTable(labelTable);
		gold_price_slider.setPaintTicks(true);
		gold_price_slider.setSnapToTicks(false);
		gold_price_slider.setPaintLabels(true);
		gold_price_slider.setMajorTickSpacing(200);
		roll_panel.add(new JLabel("Gold Price: "));
		roll_panel.add(gold_price_slider);

		avocado_slider = new JSlider(0, 100, 0);
		roll_panel.add(new JLabel("Avocado: "));
		roll_panel.add(avocado_slider);

		crab_slider = new JSlider(0, 100, 0);
		roll_panel.add(new JLabel("Crab: "));
		roll_panel.add(crab_slider);

		eel_slider = new JSlider(0, 100, 0);
		roll_panel.add(new JLabel("Eel: "));
		roll_panel.add(eel_slider);

		rice_slider = new JSlider(0, 100, 0);
		roll_panel.add(new JLabel("Rice: "));
		roll_panel.add(rice_slider);

		salmon_slider = new JSlider(0, 100, 0);
		roll_panel.add(new JLabel("Salmon: "));
		roll_panel.add(salmon_slider);

		seaweed_slider = new JSlider(0, 100, 0);
		roll_panel.add(new JLabel("Seaweed: "));
		roll_panel.add(seaweed_slider);

		shrimp_slider = new JSlider(0, 100, 0);
		roll_panel.add(new JLabel("Shrimp: "));
		roll_panel.add(shrimp_slider);

		tuna_slider = new JSlider(0, 100, 0);
		roll_panel.add(new JLabel("Tuna: "));
		roll_panel.add(tuna_slider);

		add(roll_panel, BorderLayout.NORTH);

		roll_button = new JButton("Make Roll");
		roll_button.setActionCommand("Make Roll");
		add(roll_button, BorderLayout.CENTER);

		JPanel sushi_panel = new JPanel();
		sushi_panel.setLayout(new GridLayout(2, 1));

		String[] seafood = { "Crab", "Eel", "Salmon", "Shrimp", "Tuna" };
		sashimi_type = new JComboBox(seafood);
		sushi_panel.add(new JLabel("Sashimi Type: "));
		sushi_panel.add(sashimi_type);

		sashimi_button = new JButton("Make Sashimi");
		sashimi_button.setActionCommand("Make Sashimi");
		sushi_panel.add(sashimi_button);

		sushi_panel.add(new JLabel("Nigiri Type: "));
		nigiri_type = new JComboBox(seafood);
		sushi_panel.add(nigiri_type);

		nigiri_button = new JButton("Make Nigiri");
		nigiri_button.setActionCommand("Make Nigiri");
		sushi_panel.add(nigiri_button);

		add(sushi_panel, BorderLayout.SOUTH);

		roll_button.addActionListener(this);
		sashimi_button.addActionListener(this);
		nigiri_button.addActionListener(this);

	}

	public void addWorkstationListener(WorkstationListener l) {
		listeners.add(l);
	}

	public void removeWorkstationListener(WorkstationListener l) {
		listeners.remove(l);
	}

	private void publishPlateToListeners(Plate p) {
		for (WorkstationListener l : listeners) {
			l.handleMadePlate(p);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String sushi_command = button.getActionCommand();
		Sushi sushi = null;
		if (sushi_command.equals("Make Nigiri")) {
			String nigiri_ingredient = nigiri_type.getSelectedItem().toString();
			if (nigiri_ingredient.equals("Tuna")) {
				sushi = new Nigiri(Nigiri.NigiriType.TUNA);
			}
			if (nigiri_ingredient.equals("Salmon")) {
				sushi = new Nigiri(Nigiri.NigiriType.SALMON);
			}
			if (nigiri_ingredient.equals("Eel")) {
				sushi = new Nigiri(Nigiri.NigiriType.EEL);
			}
			if (nigiri_ingredient.equals("Crab")) {
				sushi = new Nigiri(Nigiri.NigiriType.CRAB);
			}
			if (nigiri_ingredient.equals("Shrimp")) {
				sushi = new Nigiri(Nigiri.NigiriType.SHRIMP);
			}
		}
		if (sushi_command.equals("Make Sashimi")) {
			String sashimi_ingredient = sashimi_type.getSelectedItem()
					.toString();
			if (sashimi_ingredient.equals("Tuna")) {
				sushi = new Sashimi(Sashimi.SashimiType.TUNA);
			}
			if (sashimi_ingredient.equals("Salmon")) {
				sushi = new Sashimi(Sashimi.SashimiType.SALMON);
			}
			if (sashimi_ingredient.equals("Eel")) {
				sushi = new Sashimi(Sashimi.SashimiType.EEL);
			}
			if (sashimi_ingredient.equals("Crab")) {
				sushi = new Sashimi(Sashimi.SashimiType.CRAB);
			}
			if (sashimi_ingredient.equals("Shrimp")) {
				sushi = new Sashimi(Sashimi.SashimiType.SHRIMP);
			}
		}
		if (sushi_command.equals("Make Roll")) {
			ArrayList<Ingredient> ingredient_list = new ArrayList<Ingredient>();
			if (avocado_slider.getValue() != 0) {
				ingredient_list.add(new Avocado((double) (avocado_slider
						.getValue()) / 100.00));
			}
			if (crab_slider.getValue() != 0) {
				ingredient_list.add(new Crab(
						(double) (crab_slider.getValue()) / 100.00));
			}
			if (eel_slider.getValue() != 0) {
				ingredient_list.add(new Eel(
						(double) (eel_slider.getValue()) / 100.00));
			}
			if (rice_slider.getValue() != 0) {
				ingredient_list.add(new Eel(
						(double) (eel_slider.getValue()) / 100.00));
			}
			if (salmon_slider.getValue() != 0) {
				ingredient_list.add(new Salmon((double) (salmon_slider
						.getValue()) / 100.00));
			}
			if (seaweed_slider.getValue() != 0) {
				ingredient_list.add(new Seaweed((double) (seaweed_slider
						.getValue()) / 100.00));
			}
			if (shrimp_slider.getValue() != 0) {
				ingredient_list.add(new Shrimp(((double) (shrimp_slider
						.getValue()) / 100.00)));
			}
			if (tuna_slider.getValue() != 0) {
				ingredient_list.add(new Tuna(
						(double) (tuna_slider.getValue()) / 100.00));
			}

			Ingredient[] ingredients = new Ingredient[ingredient_list.size()];
			ingredient_list.toArray(ingredients);

			sushi = new Roll(ingredients);
		}
		try {
			Plate p = plateGenerator(sushi);
			publishPlateToListeners(p);
		} catch (PlatePriceException e1) {
		}
	}

	// Takes in a piece of sushi and generates a plate depending on the plate
	// color from the GUI and returns the newly generated plate
	private Plate plateGenerator(Sushi sushi) throws PlatePriceException {
		Plate plate = null;
		String plate_color = plate_type.getSelectedItem().toString();
		if (plate_color.equals("Red Plate")) {
			plate = new RedPlate(sushi);
		}
		if (plate_color.equals("Blue Plate")) {
			plate = new BluePlate(sushi);
		}
		if (plate_color.equals("Gold Plate")) {
			plate = new GoldPlate(sushi,
					((double) (gold_price_slider.getValue()) / 100.00));
		}
		if (plate_color.equals("Green Plate")) {
			plate = new GreenPlate(sushi);
		}
		return plate;
	}
}
