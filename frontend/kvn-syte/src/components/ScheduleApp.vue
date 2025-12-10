<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Расписание игр сезона
            </div>
        </h2>
    </div>
    <table class="ui celled table">
        <thead>
            <tr><th>Название игры</th>
            <th>Номер сезона</th>
            <th>Дата игры</th>
        </tr></thead>
        <tbody>
            <tr v-for="game in games" :key="game.id">
                <td><input class="ui input" type="text" name="gameName" v-model="game.gameName"></td>
                <td><input class="ui input" type="number" name="seasonNumber" v-model="game.seasonNumber"></td>
                <td><input class="ui input" type="date" name="gameDate" v-model="game.gameDate"></td>
                <td><i class="minus square icon" @click="deleteRow(game.id)"></i></td>
            </tr>
        </tbody>
    </table>
    <button class="ui button" @click="addRow">
        <i class="plus icon"></i> Добавить игру
    </button>
    <button class="ui button">
        <i class="check icon"></i> Сохранить изменения
    </button>
</template>

<script setup>
import { ref } from 'vue';

const games = ref([
    {
        id: 0,
        gameName: 'Фестиваль',
        seasonNumber: 1,
        gameDate: ''
    },
    {
        id: 1,
        gameName: 'Полуфинал',
        seasonNumber: 1,
        gameDate: ''
    },
    {
        id: 2,
        gameName: 'Финал',
        seasonNumber: 1,
        gameDate: ''
    }
])

function deleteRow(id){
    teams.value = teams.value.filter(el => el.id != id)
    for(let i = 0; i < teams.value.length; i++){
        teams.value[i].id = i
    }
}

function addRow(){
    teams.value.push({id: teams.value.length})
}
</script>