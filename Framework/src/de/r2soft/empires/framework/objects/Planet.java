/* #########################################################################
 * Copyright (c) 2014 Random Robot Softworks
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 ######################################################################### */
package de.r2soft.empires.framework.objects;

import java.util.HashSet;
import java.util.Set;

import de.r2soft.empires.framework.planetary.Orbit;
import de.r2soft.empires.framework.planetary.Orbit.ORBIT_TYPE;
import de.r2soft.empires.framework.players.Player;

/**
 * Planet object that can be claimed and raided
 * 
 * @author Katharina <kookie@spacekookie.de>
 * 
 */
public class Planet extends OrbitalObject {

  /* The diameter of the planet. NOT THE ORBIT */
  private double diam;
  /* Mass of the planet */
  private double mass;
  /* Type of the planet */
  private PlanetType type;
  /* True if this planet is the homeworld of a player. Can't be changed! */
  private boolean homeworld;
  /* True if this planet is the capital for a player. Can be changed. */
  private boolean capital;
  /* A set of moons orbiting this planet */
  private Set<Moon> moons;

  /**
   * Planet classification:
   * 
   * A: Asteroids & Rocks && B: Volcanic Planet && C: Desert Planet && D: Earth Planet && E: Ice Planet && F: Gas Planets
   * 
   * @author Katharina <kookie@spacekookie.de>
   * 
   */
  public static enum PlanetType {
	ASTEROIDS, VOLCANY, DESERTY, EARTHY, ICY, GASSY, KINKY;
	/* Kinky planets have a 50% production bonus to sex toys */
  }

  {
	moons = new HashSet<Moon>();
  }

  @Deprecated
  public Planet(Category c, double radius, BaseObject parent) {
	super.setCategory(c);
	super.setOrbitalR(radius);
  }

  /**
   * Deprecated constructor that takes the super-category, planet diameter and planetary mass.
   * 
   * @author Katharina <kookie@spacekookie.de>
   */
  @Deprecated
  public Planet(Category category, double diam, double mass) {
	super.setCategory(category);
	super.setOrbit(new Orbit(ORBIT_TYPE.CIRCULAR, getOrbitalR(), this, getParent()));

  }

  /** Default constructor that takes the super category for rendering, an orbital radius and a star as the parent object of the orbit */
  public Planet(Category category, double orbitalRadius, Star parent) {
	setCategory(category);
	super.setOrbit(new Orbit(ORBIT_TYPE.CIRCULAR, orbitalRadius, this, parent));
  }

  /** Special constructor that takes Planet mass, diameter (aka density), orbital radius and parent. Type will be generated by density. */
  public Planet(double mass, double diam, double orbitalRadius, Star parent) {
	double density = (1.0 / 6.0) * Math.PI * Math.pow(diam, 3);
	this.getTypeWithDensity(density);
  }

  private void getTypeWithDensity(double density) {

	if (density < 1)
	  type = PlanetType.EARTHY;

	else
	  type = PlanetType.GASSY;

  }

  public void addMoon(Moon moon) {
	if (!moons.contains(moon))
	  moons.add(moon);
  }

  public Set<Moon> getMoons() {
	return moons;
  }

  public boolean hasMoon(Moon moon) {
	return moons.contains(moon);
  }

  public boolean hasMoons() {
	return moons.isEmpty();
  }

  public double getDiameter() {
	return diam;
  }

  public void setDiameter(double diam) {
	this.diam = diam;
  }

  public double getMass() {
	return mass;
  }

  public void setMass(double mass) {
	this.mass = mass;
  }

  @Deprecated
  public PlanetType getPlanetType() {
	return type;
  }

  @Deprecated
  public void setPlanetType(PlanetType type) {
	this.type = type;
  }

  /** Set from server side! Homeworld can not be transfered */
  protected void setHomeworld(Player p) {
	if (p.hasPlanets())
	  this.homeworld = true;
	else
	  this.homeworld = false;
  }

  public boolean isCapital() {
	return capital;
  }

  /**
   * Sets the new capital of the empire. Checks for the old capital and if exists revokes capital status from that planet.
   */
  public void setCapital(boolean capital) {
	Planet old = super.getClaim().getCapital();
	if (old != null)
	  old.setCapital(false);
	this.capital = capital;
  }

  public boolean isHomeworld() {
	return homeworld;
  }
}
