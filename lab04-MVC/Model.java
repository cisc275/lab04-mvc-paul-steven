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
	boolean goingUp = true;
    boolean goingDown = true;
	
	int xloc = 0;
	int yloc = 0;
	int xIncr = 4;
    int yIncr = 8;
	
	public Model(int fw, int fh, int iw, int ih){
		this.FRAMEWIDTH = fw;
		this.FRAMEHEIGHT = fh;
		this.IMAGEWIDTH = iw;
		this.IMAGEHEIGHT = ih;
	}
    
    Direction d = Direction.NORTH;
    

    public int getX(){
        return xloc;
    }
    
    public int getY(){
        return yloc;
    }
    
    public Direction getDirec(){
        return d;
    }
    
    public Direction getDirection(int xDir, int yDir){
        if ( xDir < 0 ){
            if ( yDir < 0 ){
                d = Direction.NORTHWEST;
            }else if (yDir > 0){
                d = Direction.SOUTHWEST;
            }else if (yDir == 0){
                d = Direction.WEST;
        }else if (xDir > 0){
            if(yDir > 0){
                d = Direction.NORTHEAST;
            }else if (yDir < 0){
                d = Direction.SOUTHEAST;
            }else if(yDir == 0){
                d = Direction.EAST;
            }
        }else{
            if(yDir > 0){
                d = Direction.SOUTH;
            }else if (yDir < 0){
                d = Direction.NORTH;
            }
        
    }
        }
        return d;
    }
            
    public void updateLocationAndDirection(){
        checkBoundry();
        int xVel;
        int yVel;
        
        if( goingLeft){
            xVel = -xIncr;
        }else{
            xVel = xIncr;
        }
        
        if( goingUp){
            yVel = -yIncr;
        }else{
            yVel = yIncr;
        }
        
        getDirection(xVel, yVel);
        
        xloc += xVel;
        yloc += yVel;
        
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
	
//    public int nextDirection(int dir) { //return next direction after a wall hit
//        if(dir == NORTH) {
//            return SOUTH;
//        }
//        else if(dir == SOUTH) {
//            return NORTH;
//        }
//        else if(dir == EAST) {
//            return WEST;
//        }
//        else if(dir == WEST) {
//            return EAST;
//        }
//        else if(dir == NORTHEAST) { //if NORTH wall hit
//            return SOUTHEAST;
//        }
//        else if(dir == SOUTHEAST) { //if SOUTH wall hit
//            return NORTHEAST;
//        }
//        else if(dir == NORTHWEST) { //if NORTH wall hit
//            return SOUTHWEST;
//        }
//        else if(dir == SOUTHWEST) { //if SOUTH wall hit
//            return NORTHWEST;
//        }
//
//        else if(dir == NORTHEAST) { //if EAST wall hit
//            return NORTHWEST;
//        }
//        else if(dir == NORTHWEST) { //if WEST wall hit
//            return NORTHEAST;
//        }
//        else if(dir == SOUTHEAST) { //if EAST wall hit
//            return SOUTHWEST;
//        }
//        else if(dir == SOUTHWEST) { //if WEST wall hit
//            return SOUTHEAST;
//        }
//    }
	
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
