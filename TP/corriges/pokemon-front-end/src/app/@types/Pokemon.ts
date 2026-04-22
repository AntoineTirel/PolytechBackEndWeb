export type Type = {
    name1: string;
    name2: string;
    weaknesses: Type[];
    resistances: Type[];
};

export type Pokemon = {
    id: number;
    name: string;
    description: string;
    generation: number;
    type: Type;
}