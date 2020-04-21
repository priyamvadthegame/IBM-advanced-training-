const _width = Symbol('width');
export class Square {
    constructor( width0 ) {
        this[_width] = width0;
    }
    getWidth() {
        return this[_width];
    }
}