package com.happn.techtest.entities;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author zack
 *
 */

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Zone {

	private double minLat;
	private double maxLat;
	private double minLon;
	private double maxLon;

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;

		if (!(o instanceof Zone))
			return false;

		Zone z = (Zone) o;

		return Double.compare(minLat, z.minLat) == 0 && Double.compare(maxLat, z.maxLat) == 0
				&& Double.compare(minLon, z.minLon) == 0 && Double.compare(maxLon, z.maxLon) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(minLat, maxLat, minLon, maxLon);
	}

}
