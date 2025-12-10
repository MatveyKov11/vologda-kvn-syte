<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Команды сезонов
            </div>
        </h2>
    </div>
    <table class="ui table">
        <thead><tr>
            <th class="five wide">Название команды</th>
            <th class="five wide">ФИО капитана</th>
            <th class="five wide">Контакты капитана</th>
            <th class="one wide"></th>
        </tr></thead>
        <tbody>
            <tr v-for="team in teams" :key="team.id">
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="teamName" v-model="team.teamName">
                    </div>
                </td>
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="capitanFio" v-model="team.capitanFio">
                    </div>
                </td>
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="capitanContacts" v-model="team.capitanContacts">
                    </div>

                </td>
                <td><i class="minus square icon" @click="deleteRow(team.id)"></i></td>
            </tr>
        </tbody>
    </table>
    <button class="ui button" @click="addRow">
        <i class="plus icon"></i> Добавить команду
    </button>
    <button class="ui button">
        <i class="check icon"></i> Сохранить изменения
    </button>
</template>

<script setup>
import { ref } from 'vue';

const teams = ref([
    {
        id: 0,
        teamName: '35 Элемент',
        capitanFio: 'Маслов Всеволод',
        capitanContacts: '-'
    },
    {
        id: 1,
        teamName: 'Люди ФСИНем',
        capitanFio: 'Калантаев Симеон',
        capitanContacts: '-'
    },
    {
        id: 2,
        teamName: 'Хлорид Натрия',
        capitanFio: 'Лощилова Анна',
        capitanContacts: '-'
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