export class Persona{
    nombre: string;
    apellido: string;
    edad: number;
    constructor(private _nombre:string,private _apellido:string,private _edad:number){
        this.nombre=_nombre;
        this.apellido =_apellido;
        this.edad = _edad;
    }
}
