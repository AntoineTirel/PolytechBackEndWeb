export type Type = {
    name1: string;
    name2: string;
    weaknesses: Type[];
    resistances: Type[];
};

export type PokemonDTO = {
    id: number;
    name: string;
    description: string;
    generation: number;
    type: Type;
}