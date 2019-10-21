package com.happn.techtest.entities;

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
public class InterestPoints {

	private String id;
	private double latitude;
	private double longitude;

}
