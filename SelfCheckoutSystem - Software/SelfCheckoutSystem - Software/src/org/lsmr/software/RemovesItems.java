package org.lsmr.software;

import org.lsmr.selfcheckout.Item;
import org.lsmr.selfcheckout.devices.AbstractDevice;
import org.lsmr.selfcheckout.devices.ElectronicScale;
import org.lsmr.selfcheckout.devices.SelfCheckoutStation;
import org.lsmr.selfcheckout.devices.listeners.AbstractDeviceListener;
import org.lsmr.selfcheckout.devices.listeners.ElectronicScaleListener;

public class RemovesItems {
	
	private SelfCheckoutStation station;
	private int countWeightChanged;
	
	/**
	 * Constructor for RemovesItems
	 * Simulates the use case "Customer removes purchased items from bagging area"
	 * 
	 * @param station
	 * 		The SelfCheckoutStation that has the baggingArea. 
	 */
	public RemovesItems(SelfCheckoutStation station) {
		
		this.station = station;
		
		registerESListener();
		
	}
	
	/**
	 * Removes an item from the station's baggingArea 
	 * 
	 * @param item
	 * 		The Item to be removed from the station's baggingArea
	 */
	public void removesItems(Item item) {
		
		station.baggingArea.remove(item);
		
	}
	
	public void placesItems(Item item) {
		
		station.baggingArea.add(item);
		
		//CurrentWeightInGrams += item.getWeight();
		
	}
	
	/**
	 * Registers an ElectronicScaleListener to the station's baggingArea
	 */
	private void registerESListener() {
		
		ElectronicScaleListener es_listener = new ElectronicScaleListener() {
			
			@Override 
			public void enabled(AbstractDevice<? extends AbstractDeviceListener> device) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void disabled(AbstractDevice<? extends AbstractDeviceListener> device) {
				// TODO Auto-generated method stub
				
			}
			
			@Override 
			public void weightChanged(ElectronicScale scale, double weightInGrams) {
				countWeightChanged++;
				//CurrentWeightInGrams -= weightInGrams;
				
			}
			
			@Override
			public void overload(ElectronicScale scale) {
					
			}
			
			@Override
			public void outOfOverload(ElectronicScale scale) {
				
			}
			
		};
		
		station.baggingArea.register(es_listener);
		
	}

	public int getCountWeightChanged() {
		return countWeightChanged;
	}

	//public double getCurrentWeightInGrams() {
	//	return CurrentWeightInGrams;
	//}

}
