import java.awt.Color;

/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/



public class Model{
	int FRAMEWIDTH;
	int FRAMEHEIGHT;
	int IMAGEWIDTH;
	int IMAGEHEIGHT;
	
	boolean goingLeft = true;
	boolean goingDown = true;
	
	int xloc;
	int yloc;
	int xDir;
	int yDir;
	
	public Model(int fw, int fh, int iw, int ih){
		this.fw = FRAMEWIDTH;
		this.fh = FRAMEHEIGHT;
		this.iw = IMAGEWIDTH;
		this.ih = IMAGEHEIGHT;
	}
	
	
	void checkBoundry() {
		if( xloc < 0) {
			goingLeft = true;
		}else if (xloc + IMAGEWIDTH > FRAMEWIDTH){
			goingLeft = false;
		}
		if( yloc < 0) {
			goingDown = true;
		}else if (yloc + IMAGEHEIGHT > FRAMEHEIGHT) {
			goingDown = false;
		}
	}
	
	public int nextDirection(int dir) { //return next direction after a wall hit
		if(dir == NORTH) {
			return SOUTH;
		}
		else if(dir == SOUTH) {
			return NORTH;
		}
		else if(dir == EAST) {
			return WEST;
		}
		else if(dir == WEST) {
			return EAST;
		}
		else if(dir == NORTHEAST) { //if NORTH wall hit
			return SOUTHEAST;
		}
		else if(dir == SOUTHEAST) { //if SOUTH wall hit
			return NORTHEAST;
		}
		else if(dir == NORTHWEST) { //if NORTH wall hit
			return SOUTHWEST;
		}
		else if(dir == SOUTHWEST) { //if SOUTH wall hit
			return NORTHWEST;
		}
		
		else if(dir == NORTHEAST) { //if EAST wall hit
			return NORTHWEST;
		}
		else if(dir == NORTHWEST) { //if WEST wall hit
			return NORTHEAST;
		}
		else if(dir == SOUTHEAST) { //if EAST wall hit
			return SOUTHWEST;
		}
		else if(dir == SOUTHWEST) { //if WEST wall hit
			return SOUTHEAST;
		}
	}
	
	//provide direction
	
	//provide location
			
}

	


/*
picNum = (picNum + 1) % frameCount;


if (xloc <= 0) {
	if(yDir>0) {
		dir = southeast;
	}else {
		dir = northeast;
	}
    xDir = 1;
}
else if (xloc + imgWidth >= frameWidth) {
	if(yDir > 0) {
		dir = southwest;			
	}
	else {
		dir = northwest;
	}
    xDir = -1;

}

if (yloc <= 0) {
	if(xDir > 0) {
		dir = southeast;		
	}
	else {
		dir = southwest;
		
	}
    yDir = 1;
}

else if (yloc + imgHeight >= frameHeight) {
	if(xDir > 0) {
		dir = northeast;		
	}
	else {
		dir = northwest;			
	}
    yDir = -1;
}



g.drawImage(pics[dir][picNum], xloc += (xIncr * xDir), yloc += (yIncr * yDir), Color.gray, this);*//**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/
