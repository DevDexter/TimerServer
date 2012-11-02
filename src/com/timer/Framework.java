/**
 * 
 */
package com.timer;

import java.io.IOException;
import com.timer.storage.*;

import com.timer.habbohotel.HabboHotel;
import com.timer.net.TCPListener;

/**
 * all the data needed for Timer Framework.
 * @author joshuab
 */
public class Framework {
	
	@SuppressWarnings("unused")
	private static TCPListener Listener;
	
	public static String NORMAL_AVAILABLESETS = "[100,105,110,115,120,125,130,135,140,145,150,155,160,165,170,175,176,177,178,180,185,190,195,200,205,206,207,210,215,220,225,230,235,240,245,250,255,260,265,266,267,270,275,280,281,285,290,295,300,305,500,505,510,515,520,525,530,535,540,545,550,555,565,570,575,580,585,590,595,596,600,605,610,615,620,625,626,627,630,635,640,645,650,655,660,665,667,669,670,675,680,685,690,695,696,700,705,710,715,720,725,730,735,740]";
	public static String CLUB_AVAILABLESETS = "[100,105,110,115,120,125,130,135,140,145,150,155,160,165,170,175,176,177,178,180,185,190,195,200,205,206,207,210,215,220,225,230,235,240,245,250,255,260,265,266,267,270,275,280,281,285,290,295,300,305,500,505,510,515,520,525,530,535,540,545,550,555,565,570,575,580,585,590,595,596,600,605,610,615,620,625,626,627,630,635,640,645,650,655,660,665,667,669,670,675,680,685,690,695,696,700,705,710,715,720,725,730,735,740,800,801,802,803,804,805,806,807,808,809,810,811,812,813,814,815,816,817,818,819,820,821,822,823,824,825,826,827,828,829,830,831,832,833,834,835,836,837,838,839,840,841,842,843,844,845,846,847,848,849,850,851,852,853,854,855,856,857,858,859,860,861,862,863,864,865,866,867,868,869,870,871,872,873]";
	
	public static MySQL SqlManager = new MySQL();
	
	private static HabboHotel mHabboHotel = new HabboHotel();
	
	public static HabboHotel GetGame()
	{
		return mHabboHotel;
	}
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("###############################################");
		System.out.println("## Timer Framework v0.01 - FUSE Emulation V5 ##");
		System.out.println("## Made by Eric [Tha]                        ##");
		System.out.println("## Shoutouts to: [Thanks]                    ##");
		System.out.println("## Nils [Nillus] - Explaining protocol       ##");
		System.out.println("###############################################");
		System.out.println();
		
		SqlManager.Start("localhost", "root", "123", "timerdb");
		Listener = new TCPListener("127.0.0.1", 37120, 10);
	}
	
	public static int[] DecodeSpecialCharArr(char[] CharArr)
	{
		int[] Data = new int[CharArr.length];
		
		for (int i = 0; i < CharArr.length; i++)
			Data[i] = (int)CharArr[i];
		
		return Data;
	}
}
